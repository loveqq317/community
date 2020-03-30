package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/**
 * @ClassName CommentDTO
 * @Description 评论
 * @Author Q
 * @Date 2020/3/26 6:08 下午
 * @Version 1.0
 **/
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Long commentCount;
    private String content;
    private User user;
}
