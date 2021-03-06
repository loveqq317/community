package life.majiang.community.controller;

import life.majiang.community.dto.CommentCreateDTO;
import life.majiang.community.dto.CommentDTO;
import life.majiang.community.dto.ResultDTO;
import life.majiang.community.enums.CommentTypeEnum;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.model.Comment;
import life.majiang.community.model.User;
import life.majiang.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        if (commentDTO == null || StringUtils.isBlank(commentDTO.getContent())){
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
    @ResponseBody
    @RequestMapping(value = "/comment/{id}",method = RequestMethod.GET)
    public ResultDTO<List> comments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOS=commentService.listByParentId(id, CommentTypeEnum.COMMENT.getType());
       return ResultDTO.okOf(commentDTOS);
    }
}
