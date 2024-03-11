package lian.user;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    //查询全部用户

    List<User> getUserList();

    // 根据id查询用户信息
    User getUserById(int id);
    //注册一个用户
    int addUser(User user);

    //万能的map
    //修改用户
    int updateUser(User user);
    //删除一个用户

    int deleteUser(int id);

    //上传头像更新头像
    int  updateAvatar_url(int id,String avatar_url);
    //分页
    List<User> getUserByLimit(Map<String,Integer> map);
}

