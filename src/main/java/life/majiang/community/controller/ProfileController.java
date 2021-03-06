package life.majiang.community.controller;

import life.majiang.community.dto.PageDTO;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName ProfileController
 * @Description TODO
 * @Author Q
 * @Date 2020/3/23 12:18 下午
 * @Version 1.0
 **/
@Controller
public class ProfileController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/profile/{section}")
    public String profile(@PathVariable(name = "section") String section,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "5") Integer size){
        Cookie[] cookies=request.getCookies();
        User user= (User) request.getSession().getAttribute("user");
        if (user == null ){
            return "redirect:/";
        }
        if ("questions".equals(section)){
            model.addAttribute("section","question");
            model.addAttribute("sectionName","我的问题");
        }else if("replies".equals(section)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }
        PageDTO pageDTO=questionService.list(user.getId(),page,size);
        model.addAttribute("pagination",pageDTO);
        return "profile";
    }
}
