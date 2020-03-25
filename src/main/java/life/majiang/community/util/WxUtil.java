package life.majiang.community.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
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
}
