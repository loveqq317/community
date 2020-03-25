package life.majiang.community.model;

import life.majiang.community.wx.BaseMessage;
import lombok.Data;

import java.io.InputStream;

/**
 * @ClassName WxToken
 * @Description TODO
 * @Author Q
 * @Date 2020/3/24 9:58 下午
 * @Version 1.0
 **/
public class Token {
    private Integer id;
    private String accessToken;
    private Long expireTime;

    public Token(String accessToken, Long expiresIn) {
        super();
       this.accessToken = accessToken;
        expireTime = System.currentTimeMillis()+ expiresIn;
    }

    public Token(Integer id, String accessToken, Long expireTime) {
        this.id = id;
        this.accessToken = accessToken;
        this.expireTime = expireTime;
    }

    /**
     * @Author juyahong
     * @Description  判断token是否过期
     * @Date 10:18 上午 2020/3/25
     * @Param []
     * @return boolean
     **/
    public boolean isExpired(){
        return System.currentTimeMillis()>this.expireTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}
