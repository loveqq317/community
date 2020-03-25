package life.majiang.community.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.ocr.AipOcr;
import com.thoughtworks.xstream.XStream;
import life.majiang.community.mapper.TokenMapper;
import life.majiang.community.model.Token;
import life.majiang.community.util.WxUtil;
import life.majiang.community.wx.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * @ClassName WxService
 * @Description 验证签名
 * @Author jyh
 * @Date 2020/3/24 3:47 下午
 * @Version 1.0
 **/
@Service
public class WxService {
    @Value("${wx.token}")
    private String tokenDelete;
    @Value("${wx.get.token.url}")
    private String tokenUrl;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;
    @Value("${wx.api.media.upload}")
    private String mediaUploadUrl;
    @Autowired
    private WxUtil wxUtil;
    @Autowired
    private TokenMapper tokenMapper;

    //设置APPID/AK/SK
    @Value("${baidu.app.id}")
    private  String appId;
    @Value("${baidu.api.key}")
    private  String apiKey;
    @Value("${baidu.secret.key}")
    private  String secretKey;
    /**
     * @Author juyahong
     * @Description 获取token
     * @Date 10:19 上午 2020/3/25
     * @Param []
     * @return java.lang.String
     **/
    private  Token  getToken(){
        System.out.println(tokenUrl);
        String url=tokenUrl.replace("APPID",appid).replace("APPSECRET",secret);
        String tokenStr=wxUtil.get(url);
        System.out.println("tokenStr"+tokenStr);
        JSONObject jsonObject= JSONObject.parseObject(tokenStr);
        String token=jsonObject.getString("access_token");
        Long expiresIn=jsonObject.getLong("expires_in");
        Token wxToken=new Token(token,expiresIn);
        return wxToken;
    }
    public  String getAccessToken(){
        //从数据库里获取token，如果判断没有token，或者是token已经过期了，就要重新获取token，并存储
        Token oldToken=tokenMapper.getTokenDB();
        if (null != oldToken ){
            //存在token，判断是否过期
            if (oldToken.isExpired()){
                //过期了，需要重新获取，并更新表token
               Token newToken= this.getToken();
               newToken.setId(oldToken.getId());
               tokenMapper.update(newToken);
               return newToken.getAccessToken();
            }else{
                return oldToken.getAccessToken();
            }
        }else{
            //数据库不存在token，重新获取并新增
            Token newToken=this.getToken();
            tokenMapper.add(newToken);
            return newToken.getAccessToken();
        }
    }
    public boolean check(String timestamp, String nonce, String signature) {
//      1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strs=new String[]{tokenDelete,timestamp,nonce};
        Arrays.sort(strs);
//      2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str=strs[0]+strs[1]+strs[2];
//      3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        String mySignature=sha1(str);
        System.out.println("我计算的结果"+mySignature);
        System.out.println("原结果"+signature);
        return mySignature.equalsIgnoreCase(signature);
    }

    private String sha1(String str) {
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("sha1");
            byte[] digest=messageDigest.digest(str.getBytes());
            char[] chars={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuffer sb=new StringBuffer();
            for(byte b : digest){
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[b&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> parseRequst(InputStream is) {
        Map<String,String > map = new HashMap<>();
        SAXReader reader =new SAXReader();
        try {
            //读取输入流，获取文档对象
            Document document=reader.read(is);
            //根据对象，获取根节点
            Element root =document.getRootElement();
            List<Element> rootElements=root.elements();
            for(Element e : rootElements){
                map.put(e.getName(),e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }
    /**
     * @Author juyahong
     * @Description //处理事件和消息的回复
     * @Date 5:11 下午 2020/3/24
     * @Param [req]
     * @return java.lang.String
     **/
    public String getResponse(Map<String,String> requestMap) {
       // WxBaseMessage wxBaseMessage=null;
        BaseMessage msgObj=null;
        String msgType=requestMap.get("MsgType");
        switch (msgType){
            case "text":
                msgObj=dealTextMessage(requestMap);
                break;
            case "image":
                msgObj=dealImageMessage(requestMap);
                break;
            case "voice":
                break;
            case "video":
                break;
            case "shortvideo":
                break;
            case "location":
                break;
            case "event":
                msgObj=dealEvent(requestMap);
                break;
            default:
                break;
        }
        if (null != msgObj){
            return beanToXml(msgObj);
        }
        return null;
    }
    /**
     * @Author juyahong
     * @Description //进行图片识别
     * @Date 2:26 下午 2020/3/25
     * @Param [requestMap]
     * @return life.majiang.community.wx.BaseMessage
     **/
    private BaseMessage dealImageMessage(Map<String, String> requestMap) {
//      初始化一个AipOcr
        AipOcr client = new AipOcr(appId, apiKey, secretKey);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        // client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
       // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("recognize_granularity", "big");
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("vertexes_location", "true");
        options.put("probability", "true");
        // 调用接口
        String path = requestMap.get("PicUrl");
        //option可以传 new HashMap<>
        org.json.JSONObject res =  client.generalUrl(path, options);

        JSONArray jsonArray=res.getJSONArray("words_result");
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<jsonArray.length();i++){
            org.json.JSONObject jsonObject=jsonArray.getJSONObject(i);
            stringBuilder.append(jsonObject.get("words"));
        }

        return new TextMessageRequest(requestMap,stringBuilder.toString());
    }

    /**
     * @Author juyahong
     * @Description //事件推送
     * @Date 2:08 下午 2020/3/25
     * @Param [requestMap]
     * @return life.majiang.community.wx.BaseMessage
     **/
    private BaseMessage dealEvent(Map<String, String> requestMap) {
        String event=requestMap.get("Event");
        switch (event){
            case "CLICK":
                return dealClick(requestMap);
            case "VIEW":
                return dealView(requestMap);

            default:
                break;
        }
        return null;
    }

    private BaseMessage dealView(Map<String, String> requestMap) {
        return null;
    }

    /**
     * @Author juyahong
     * @Description //专门用来出来Click菜单
     * @Date 2:16 下午 2020/3/25
     * @Param [requestMap]
     * @return life.majiang.community.wx.BaseMessage
     **/
    private BaseMessage dealClick(Map<String, String> requestMap) {
        String eventKey=requestMap.get("EventKey");
        switch (eventKey){
            case "1":
                //处理点击第一个一级菜单
                return new TextMessageRequest(requestMap,"你点击了第一个一级菜单");
            case "3222":
                break;
            default:
                break;
        }
        return  null;
    }

    /**
     * @Author juyahong
     * @Description //对象转xml
     * @Date 7:38 下午 2020/3/24
     * @Param [msgObj]
     * @return java.lang.String
     **/
    private String beanToXml(BaseMessage msgObj) {
        XStream xStream=new XStream();
        xStream.processAnnotations(TextMessageRequest.class);
        xStream.processAnnotations(ImageMessageRequest.class);
        xStream.processAnnotations(MusicMessageRequest.class);
        xStream.processAnnotations(NewsMessageRequest.class);
        xStream.processAnnotations(VideoMessageRequest.class);
        xStream.processAnnotations(VoiceMessageRequest.class);
        String xml=xStream.toXML(msgObj);
        return xml;
    }

    /**
     * @Author juyahong
     * @Description //处理文本消息
     * @Date 5:32 下午 2020/3/24
     * @Param [requestMap]
     * @return life.majiang.community.dto.WxBaseMessage
     **/
    private BaseMessage dealTextMessage(Map<String, String> requestMap) {
        String msg=requestMap.get("Content");
        if (msg.equals("图文")){
            List<NewsMessageRequest.News> articles=new ArrayList<>();
            NewsMessageRequest.News news=new NewsMessageRequest.News();
            news.setTitle("这是图文标题");
            news.setDescription("这是图文描述");
            news.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/eVbPKb8DKFH52EUvYQhkibcF1LnmuvpS7IiaC28bzDCb57vRGNUwY8TDkAZoMX94YFNAx9ctY9EPaNl7W2D1MlAw/0");
            news.setUrl("www.baidu.com");
            articles.add(news);
            NewsMessageRequest newsMessageRequest=new NewsMessageRequest(requestMap,1,articles);
            return  newsMessageRequest;
        }
        TextMessageRequest textMessageRequest=new TextMessageRequest(requestMap,"你好呀");
        return textMessageRequest;
    }
    /**
     * @Author juyahong
     * @Description //上传临时素材
     * @Date 4:49 下午 2020/3/25
     * @Param [path, type]
     * @return java.lang.String
     **/
    public String upload(String path,String type){
        File file=new File(path);
        String url=mediaUploadUrl.replace("ACCESS_TOKEN",this.getAccessToken()).replace("TYPE",type);

        try {
            URL urlObj=new URL(url);
            //强转为安全连接
            HttpsURLConnection connection= (HttpsURLConnection) urlObj.openConnection();
            //设置连接信息
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            //设置请求头信息
            connection.setRequestProperty("Connection","Keep-Alive");
            connection.setRequestProperty("Charset","utf8");
            //数据的边界
            String boundary="-----" + System.currentTimeMillis();
            connection.setRequestProperty("Content-Type","multipart/form-data;boundary="+boundary);
            OutputStream out = connection.getOutputStream();
            InputStream inputStream = new FileInputStream(file);
            //第一部分：头部信息
            //准备头部信息
            StringBuilder sb=new StringBuilder();
            sb.append("--");
            sb.append(boundary);
            sb.append("\r\n");
            sb.append("Content-Dispositon:form-data;name=\"media\";filename=\"" + file.getName()+"\"\r\n");
            sb.append("Content-type:application/octet-stream\r\n\r\n");
            out.write(sb.toString().getBytes());

            //第二部分：文件内容
            byte[] b=new byte[1024];
            int len;

            while ((len=inputStream.read(b))!= -1) {
               out.write(b,0,len);
            }
            //第三部分：尾部信息
            String foot="\r\n--"+boundary+"--\r\n";
            out.write(foot.getBytes());
            out.flush();
            out.close();
            //读取数据
            InputStream is2=connection.getInputStream();
            StringBuilder resp=new StringBuilder();
            while((len=is2.read(b))!=-1){
                resp.append(new String(b,0,len));
            }
            return resp.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
