package life.majiang.community.controller;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.tools.javac.comp.Annotate;
import life.majiang.community.dto.CommentDTO;
import life.majiang.community.dto.ResultDTO;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.mapper.CommentMapper;
import life.majiang.community.model.Comment;
import life.majiang.community.model.User;
import life.majiang.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CommentController
 * @Description TODO
 * @Author Q
 * @Date 2020/3/26 5:57 下午
 * @Version 1.0
 **/
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        if (user == null ){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment coment= new Comment();
        coment.setParentId(commentDTO.getParentId());
        coment.setContent(commentDTO.getContent());
        coment.setType(commentDTO.getType());
        coment.setGmtCreate(System.currentTimeMillis());
        coment.setGmtModified(coment.getGmtCreate());
        coment.setCommentator(user.getId());
        coment.setLikeCount(0L);
        commentService.insert(coment);
        return ResultDTO.okOf();
    }
}
