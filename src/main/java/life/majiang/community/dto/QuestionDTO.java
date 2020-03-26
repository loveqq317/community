package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/**
 * @ClassName QuestionDTO
 * @Description TODO
 * @Author Q
 * @Date 2020/3/22 1:56 下午
 * @Version 1.0
 **/
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
