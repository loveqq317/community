package life.majiang.community.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName WxUtil
 * @Description TODO
 * @Author Q
 * @Date 2020/3/24 9:33 下午
 * @Version 1.0
 **/
@Component
public class WxUtil {
    /**
     * @Author juyahong
     * @Description 向指定地址发送get请求
     * @Date 9:42 下午 2020/3/24
     * @Param []https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
     * @return java.lang.String
     **/
    public  String get(String url){
        try {
            URL urlObj=new URL(url);
            //开连接
            URLConnection connection=urlObj.openConnection();
            InputStream inputStream=connection.getInputStream();
            byte[] bytes=new byte[1024];
            int len;
            StringBuilder stringBuilder=new StringBuilder();
            while ((len=inputStream.read(bytes))!= -1){
                stringBuilder.append(new String(bytes,0,len));
            }
            return  stringBuilder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author juyahong
     * @Description //向指定地址发送post请求
     * @Date 1:49 下午 2020/3/25
     * @Param [url, data]
     * @return java.lang.String
     **/
    public String post(String url,String data){
        try {
            URL urlObj=new URL(url);
            //开连接
            URLConnection connection=urlObj.openConnection();
            //设置为可发送数据状态
            connection.setDoOutput(true);
            //获取输出流
            OutputStream os=connection.getOutputStream();
            //写出数据
            os.write(data.getBytes());
            os.close();
            //获取输入流
            InputStream inputStream=connection.getInputStream();
            byte[] bytes=new byte[1024];
            int len;
            StringBuilder stringBuilder=new StringBuilder();
            while ((len=inputStream.read(bytes))!= -1){
                stringBuilder.append(new String(bytes,0,len));
            }
            return stringBuilder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
