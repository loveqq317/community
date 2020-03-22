package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName PublishController
 * @Description 发布 控制器
 * @Author Q
 * @Date 2020/3/22 9:17 上午
 * @Version 1.0
 **/
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
}
