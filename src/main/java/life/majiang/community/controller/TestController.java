package life.majiang.community.controller;

import com.alibaba.fastjson.JSONObject;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Q
 * @Date 2020/3/27 9:43 下午
 * @Version 1.0
 **/
@Controller
public class TestController {
    @Autowired
    private QuestionMapper questionMapper;
    @GetMapping("/test/question")
    @ResponseBody
    public Object getQuestion(){
        Question question = questionMapper.selectByPrimaryKey(1L);
        return JSONObject.toJSON(question);
    }
}
