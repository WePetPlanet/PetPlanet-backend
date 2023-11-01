package top.zynorl.petplanet.user.service.impl;

import top.zynorl.petplanet.user.mbg.model.User;

import java.util.List;

/**
 * Created by zynorl on 2023/11/1 10:13
 */
public interface UserService {
    List<User> listAllUser();

    int createUser(User user);

    int updateUser(Long id, User user);

    int deleteUser(Long id);

    List<User> listUser(int pageNum, int pageSize);

    User getUser(Long id);
}
