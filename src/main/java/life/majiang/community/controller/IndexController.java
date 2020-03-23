package life.majiang.community.controller;

import life.majiang.community.dto.PageDTO;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName IndexController
 * @Description 首页控制器
 * @Author Q
 * @Date 2020/3/21 1:55 下午
 * @Version 1.0
 **/
@Controller
public class IndexController {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){
        PageDTO pageDTO=questionService.list(page,size);
        model.addAttribute("pagination",pageDTO);
        return "index";
    }
}
