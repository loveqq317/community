package life.majiang.community.model;

import lombok.Data;

/**
 * @ClassName Question
 * @Description 问题 实体
 * @Author Q
 * @Date 2020/3/22 10:41 上午
 * @Version 1.0
 **/
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private int creator;
    private int commentCount;
    private int viewCount;
    private int likeCount;
    private String tag;


}