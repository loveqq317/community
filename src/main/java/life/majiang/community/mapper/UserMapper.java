package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Q
 * @Date 2020/3/21 7:09 下午
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (name,account_id,token,gmt_create,gmt_modified,avatar_url) VALUES ( #{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByUser(String token);

    @Select("select * from user where id=#{id}")
    User findById(Integer creator);
    @Select("select * from user where account_id=#{accountId} order by gmt_create desc limit 1")
    User findByAccountId(String accountId);
    @Select("update user set name=#{name}, token=#{token},gmt_modified=#{gmtModified},bio=#{bio},avatar_url=#{avatarUrl} where account_id=#{accountId}")
    void update(User user);
}
