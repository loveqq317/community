package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Q
 * @Date 2020/3/21 7:09 下午
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (name,account_id,token,gmt_create,gmt_modified) VALUES ( #{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    public void insert(User user);
}
