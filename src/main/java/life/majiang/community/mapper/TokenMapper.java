package life.majiang.community.mapper;

import life.majiang.community.model.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName WxTokenMapper
 * @Description TODO
 * @Author Q
 * @Date 2020/3/25 10:40 上午
 * @Version 1.0
 **/
@Mapper
public interface TokenMapper {
    @Insert("insert into token (access_token,expire_time) values (#{accessToken},#{expireTime})")
    void add(Token token);

    @Select("select * from token limit 1")
     Token getTokenDB();

    @Update("update token set access_token=#{accessToken},expire_time=#{expireTime} where id=#{id}")
    void update(Token token);
    @Select("select access_token from token limit 1")
    String getToken();
}
