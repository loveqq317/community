package life.majiang.community.service;

import com.sun.java.swing.ui.CommonMenuBar;
import life.majiang.community.enums.CommentTypeEnum;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import life.majiang.community.mapper.CommentMapper;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author Q
 * @Date 2020/3/26 7:01 下午
 * @Version 1.0
 **/
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    public void insert(Comment comment){
        if (comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARM_NOT_FOUND);
        }
        if (comment.getType() != null || !CommentTypeEnum.isExist(comment.getType())){
            throw  new CustomizeException((CustomizeErrorCode.TYPE_PARM_WRONG));
        }
        if (comment.getType() ==CommentTypeEnum.COMMENT.getType() ){
            //回复评论
            Comment dbComment=commentMapper.selectByPrimaryKey(comment.getParentId());
            if(dbComment == null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_EXIST);
            }else{
                commentMapper.insert(comment);
            }
        }else{
            //回复问题

        }
    }
}
