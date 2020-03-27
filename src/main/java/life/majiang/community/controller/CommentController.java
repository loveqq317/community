package life.majiang.community.controller;

import life.majiang.community.dto.CommentCreateDTO;
import life.majiang.community.dto.ResultDTO;
import life.majiang.community.exception.CustomizeErrorCode;
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
    public Object post(@RequestBody CommentCreateDTO commentDTO,
                       HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        if (user == null ){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (commentDTO == null || commentDTO.getContent() == null || commentDTO.getContent().trim().equals("")){
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
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
