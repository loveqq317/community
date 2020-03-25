package life.majiang.community.community;

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.ocr.AipOcr;
import com.thoughtworks.xstream.XStream;
import life.majiang.community.mapper.TokenMapper;
import life.majiang.community.util.WxUtil;
import life.majiang.community.wx.*;
import life.majiang.community.service.WxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CommunityApplicationTests {
    @Autowired
    private WxService wxService;
    @Autowired
    private TokenMapper tokenMapper;
    @Autowired
    private WxUtil wxUtil;
    @Value("${wx.add.menu.url}")
    private String addMenuUrl;
    @Value("${wx.api.set.industry}")
    private String setIndustryUrl;
    @Value("${wx.api.get.industry}")
    private String getindustryUrl;
    @Value("${wx.api.send.template.message}")
    private String sendTemplateMessageUrl;
    //设置APPID/AK/SK
    public static final String APP_ID = "19067523";
    public static final String API_KEY = "1tW3MZhXO80dsganb1g6OG81";
    public static final String SECRET_KEY = "pggKuQyUiiZBix7aDrCQbWmLDNR7VFqo";
    @Test
    void contextLoads() {
    }
    @Test
    public void testMsg(){
        Map<String,String> requestMap=new HashMap<>();
        requestMap.put("ToUserName","to");
        requestMap.put("FromUserName","from");
        requestMap.put("MsgType","type");

        TextMessageRequest textMessageRequest=new TextMessageRequest(requestMap, "你好啊");

        ImageMessageRequest.Image image=new ImageMessageRequest.Image();
        image.setMediaId("111");
        ImageMessageRequest imageMessageRequest=new ImageMessageRequest(requestMap,image);
        MusicMessageRequest.Music music=new MusicMessageRequest.Music();
        music.setTitle("title");
        music.setDescription("description");
        MusicMessageRequest musicMessageRequest=new MusicMessageRequest(requestMap,music);

        XStream xStream=new XStream();
        xStream.processAnnotations(TextMessageRequest.class);
        xStream.processAnnotations(ImageMessageRequest.class);
        String xmlString=xStream.toXML(textMessageRequest);
        String xmlImage=xStream.toXML(imageMessageRequest);
        System.out.println(xmlImage);
    }
    @Test
    public void testToken(){
        System.out.println(wxService.getAccessToken());
        System.out.println(wxService.getAccessToken());


    }
    /**
     * @Author juyahong
     * @Description //新增菜单
     * @Date 2:06 下午 2020/3/25
     * @Param []
     * @return void
     **/
    @Test
    public void testButton(){
        //菜单对象
        Button button=new Button();
        //第一个一级菜单
        button.getButton().add(new ClickButton("一级点击","1"));
        //第二个一级菜单
        button.getButton().add(new ViewButton("菜单","https://www.baidu.com"));
        //二级菜单到第三个一级菜单里
        SubButton subButton=new SubButton("子菜单");
        subButton.getSub_button().add(new PhotoOrAlbumButton("传图","3232"));
        subButton.getSub_button().add(new ClickButton("点击","3222"));
        subButton.getSub_button().add(new ViewButton("网易新闻","https://news.163.com"));
        //第三个一级菜单
        button.getButton().add(subButton);
        //转json
        JSONObject jsonObject= (JSONObject) JSONObject.toJSON(button);
        System.out.println(jsonObject.toString());
        String url=addMenuUrl.replace("ACCESS_TOKEN",wxService.getAccessToken());
        String result=wxUtil.post(url,jsonObject.toString());
        System.out.println(result);
    }
    @Test
    public void testBaiduAI(){
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        // client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "/Users/Q/work/test.jpg";
        org.json.JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString());

    }
    @Test
    public void setIndustry(){
        String token=wxService.getAccessToken();
        String url=setIndustryUrl.replace("ACCESS_TOKEN",token);
        String data="{\n" +
                "    \"industry_id1\":\"1\",\n" +
                "    \"industry_id2\":\"4\"\n" +
                "}";
        String result=wxUtil.post(url,data);
        System.out.println(result);
    }
    @Test
    public void getIndustry(){
        String token=wxService.getAccessToken();
        String url= getindustryUrl.replace("ACCESS_TOKEN",token);
        String result=wxUtil.get(url);
        System.out.println(result);
    }
    @Test
    public void sendTemplateMessage(){
        String token=wxService.getAccessToken();
        String url=sendTemplateMessageUrl.replace("ACCESS_TOKEN",token);
        String data="{\n" +
                "           \"touser\":\"or_r-s9_Q5x6IzqxlydH55lgHm70\",\n" +
                "           \"template_id\":\"EH9a6YMX2Dx8MQ6nRoUIA_KwpvGneqBql793e-NpHHg\",\n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"您有新的反馈消息！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"company\":{\n" +
                "                       \"value\":\"河北贞心真义公司\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"time\": {\n" +
                "                       \"value\":\"2020年4月1日\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"result\": {\n" +
                "                       \"value\":\"面试通过\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"恭喜您，请准时来公司报道！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        String result=wxUtil.post(url,data);
        System.out.println(result);
    }
    @Test
    public void testUpload(){
        String path="/Users/Q/work/学习/017-community/test.jpg";
        String result=wxService.upload(path,"image");
        // hRqIbx1bC6aOdY4G5sNbqlkajZH6NYinbOKRACCmF5hfPrefBrySR1-PEO3BZfwe
        System.out.println(result);
    }
}
