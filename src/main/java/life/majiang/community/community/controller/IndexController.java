package life.majiang.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName IndexController
 * @Description 首页控制器
 * @Author Q
 * @Date 2020/3/21 1:55 下午
 * @Version 1.0
 **/
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
