package life.majiang.community.service;

import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Q
 * @Date 2020/3/23 5:25 下午
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void createOrUpdate(User user) {
        //如果数据能查询到accountID，就更新数据，没有的话，就新增
        User dbUser=userMapper.findByAccountId(user.getAccountId());
        if(null != dbUser ){ //更新
            user.setGmtModified(System.currentTimeMillis());
            user.setId(dbUser.getId());
            userMapper.update(user);
        }else{//新增
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
    }


}
