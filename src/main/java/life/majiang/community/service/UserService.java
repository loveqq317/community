package life.majiang.community.service;

import com.sun.tools.javac.comp.Annotate;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.model.UserExample;
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
        UserExample userExample=new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> dbUsers=userMapper.selectByExample(userExample);
        if(null != dbUsers && dbUsers.size()>0){ //更新
            User dbUser=dbUsers.get(0);

            User updateUser= new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            UserExample example=new UserExample();
            example.createCriteria().andIdEqualTo(dbUser.getId());

            userMapper.updateByExampleSelective(updateUser,example);
        }else{//新增
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
    }


}
