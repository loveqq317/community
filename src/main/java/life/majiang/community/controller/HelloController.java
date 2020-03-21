package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Q
 * @Date 2020/3/21 12:44 下午
 * @Version 1.0
 **/
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(@RequestParam(name="name") String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
