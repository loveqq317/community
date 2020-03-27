package life.majiang.community.service;

import com.sun.java.swing.ui.CommonMenuBar;
import life.majiang.community.dto.CommentDTO;
import life.majiang.community.enums.CommentTypeEnum;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import life.majiang.community.mapper.CommentMapper;
import life.majiang.community.mapper.QuestionExpMapper;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private QuestionExpMapper questionExpMapper;
    @Autowired
    private UserMapper userMapper;
    @Transactional
    public void insert(Comment comment){
        if (comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARM_NOT_FOUND);
        }
        if (comment.getType() != null && !CommentTypeEnum.isExist(comment.getType())){
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
            Question question=questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null ){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExpMapper.incCommentCount(question);
        }
    }

    public List<CommentDTO> listByParentId(Long id,Integer type) {
        CommentExample example=new CommentExample();
        example.createCriteria().andParentIdEqualTo(id).andTypeEqualTo(type);
        example.setOrderByClause("gmt_create desc");
        List<Comment> comments=commentMapper.selectByExample(example);
        if (comments == null || comments.size() == 0){ return new ArrayList<>();}
        //获取去重的评论人ID
        List<Long> userIds=comments.stream().map(comment -> comment.getCommentator()).distinct().collect(Collectors.toList());
        //获取评论人用户列表
        UserExample userExample=new UserExample();
        userExample.createCriteria().andIdIn(userIds);
        List<User> userList=userMapper.selectByExample(userExample);
        Map<Long,User> userMap = userList.stream().collect(Collectors.toMap(user -> user.getId(),user -> user));
        List<CommentDTO> commentDTOS=comments.stream().map(comment -> {
            CommentDTO commentDTO=new CommentDTO();
            BeanUtils.copyProperties(comment,commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            return commentDTO;
        }).collect(Collectors.toList());
        return commentDTOS;
    }

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>(Arrays.asList(1L, 1L, 2L, 3L, 3L, 3L, 4L, 5L, 6L, 6L, 6L, 7L, 8L));
        System.out.println(list);
        List<Long> newList=list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
    }
}
