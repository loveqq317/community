package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

import java.util.List;

/**
 * @ClassName QuestionDTO
 * @Description TODO
 * @Author Q
 * @Date 2020/3/22 1:56 下午
 * @Version 1.0
 **/
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
