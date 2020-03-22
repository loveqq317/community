package life.majiang.community.model;

import lombok.Data;
import sun.tools.tree.LongExpression;

/**
 * @ClassName User
 * @Description TODO
 * @Author Q
 * @Date 2020/3/21 7:25 下午
 * @Version 1.0
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
    private String bio;
}
