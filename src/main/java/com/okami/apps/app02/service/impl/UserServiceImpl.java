package com.okami.apps.app02.service.impl;
import com.okami.apps.app02.bean.User;
import com.okami.apps.app02.dao.UserMapper;
import com.okami.apps.app02.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> query(User user){
        return userMapper.query(user);
    }
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findById(long id) {
        //调用dao层代码完成操作
        return userMapper.selectByPrimaryKey(id);
    }



    @Override
    public void saveOrUpdate(User user) throws Exception{
        if(user.getId()==null){
            //初始化属性
            user.setStatus("正常");
            System.out.println("已插入");
            userMapper.insert(user);
        }else{
            userMapper.update(user);
            System.out.println("已修改");
        }
    }

    @Override
    public void deleteById(long id) throws Exception{
        User user=userMapper.selectByPrimaryKey(id);
        if(user==null){
            throw new Exception("要删除的用户不存在");
        }else{
            userMapper.deleteByPrimaryKey(id);
        }
    }
}
