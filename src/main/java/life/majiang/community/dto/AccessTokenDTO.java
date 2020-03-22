package life.majiang.community.dto;

import lombok.Data;

/**
 * @ClassName AccesstokenDTO
 * @Description TODO
 * @Author Q
 * @Date 2020/3/21 4:06 下午
 * @Version 1.0
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
