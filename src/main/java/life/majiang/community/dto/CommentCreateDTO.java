package life.majiang.community.dto;

import lombok.Data;

/**
 * @ClassName CommentDTO
 * @Description 评论
 * @Author Q
 * @Date 2020/3/26 6:08 下午
 * @Version 1.0
 **/
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
