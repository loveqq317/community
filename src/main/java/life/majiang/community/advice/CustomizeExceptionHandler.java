package life.majiang.community.advice;

import com.alibaba.fastjson.JSONObject;
import life.majiang.community.dto.ResultDTO;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;import org.springframework.http.HttpStatus;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.ControllerAdvice;import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName CustomizeExceptionHandler
 * @Description 处理错误信息，返回error.html
 * @Author Q
 * @Date 2020/3/26 3:28 下午
 * @Version 1.0
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    Object handle(HttpServletRequest request,Throwable ex,Model model,HttpServletResponse response){
        String contentType=request.getParameter("Content-Type");
        if("application/json".equals(contentType)){
            ResultDTO resultDTO;
            if(ex instanceof CustomizeException){
                resultDTO= ResultDTO.errorOf((CustomizeException)ex);
            }else{
               resultDTO= ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer=response.getWriter();
                writer.write(JSONObject.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }else{
            //错误页面跳转
            if (ex instanceof CustomizeException){
                model.addAttribute("message",ex.getMessage());
            }else{
                model.addAttribute("message",CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }

    }
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode=(Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
