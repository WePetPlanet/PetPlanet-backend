package top.zynorl.petplanet.user.service.impl;

/**
 * Created by zynorl on 2023/11/1 10:14
 */

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.user.mbg.mapper.UserMapper;
import top.zynorl.petplanet.user.mbg.model.User;
import top.zynorl.petplanet.user.mbg.model.UserExample;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAllUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public int createUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(Long id, User user) {
        user.setId(id);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> listUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}


