package life.majiang.community.dto;

import lombok.Data;
import org.springframework.scheduling.support.SimpleTriggerContext;

/**
 * @ClassName GithubUser
 * @Description TODO
 * @Author Q
 * @Date 2020/3/21 4:40 下午
 * @Version 1.0
 **/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;


}
