package life.majiang.community.community;

import com.thoughtworks.xstream.XStream;
import life.majiang.community.mapper.TokenMapper;
import life.majiang.community.service.WxService;
import life.majiang.community.wx.ImageMessageRequest;
import life.majiang.community.wx.MusicMessageRequest;
import life.majiang.community.wx.TextMessageRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CommunityApplicationTests {
    @Autowired
    private WxService wxService;
    @Autowired
    private TokenMapper tokenMapper;
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
}
