package life.majiang.community.servlet;

import life.majiang.community.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName WxServlet
 * @Description TODO
 * @Author Q
 * @Date 2020/3/24 2:34 下午
 * @Version 1.0
 **/
@WebServlet(name = "wxServlet",urlPatterns = "/wx",asyncSupported = true)
public class WxServlet extends HttpServlet {
    @Autowired
    private WxService wxService;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet来了");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        timestamp	时间戳
        nonce	随机数
        echostr	随机字符串*/
        String signature=req.getParameter("signature");
        String timestamp=req.getParameter("timestamp");
        String nonce=req.getParameter("nonce");
        String echostr=req.getParameter("echostr");
        //校验请求
        if(wxService.check(timestamp,nonce,signature)){
            PrintWriter out =resp.getWriter();
            //原样返回echostr参数
            out.println(echostr);
            out.flush();
            out.close();
            System.out.println("接入成功");
        }else{
            System.out.println("接入失败");
        }


    }
    /**
     * @Author juyahong
     * @Description //接收消息
     * @Date 4:40 下午 2020/3/24
     * @Param [req, resp]
     * @return void
     **/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf8");
       resp.setCharacterEncoding("utf8");
        //处理消息和事件推送
        Map<String,String> requestMap=wxService.parseRequst(req.getInputStream());
        System.out.println(requestMap);
        //准备回复的数据包
      /*  String respXml="<xml>\n" +
                "  <ToUserName><![CDATA["+requestMap.get("FromUserName")+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+requestMap.get("ToUserName")+"]]></FromUserName>\n" +
                "  <CreateTime>"+System.currentTimeMillis()/1000+"</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[你好]]></Content>\n" +
                "</xml>\n";*/
        String respXml = wxService.getResponse(requestMap);
        System.out.println(respXml);
        PrintWriter out=resp.getWriter();
        out.println(respXml);
        out.flush();
        out.close();
    }
}
