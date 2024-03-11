package lian.relationship;

import java.util.List;
import lian.user.*;

public interface RelationShipMapper {
    // 用户关注另一个用户
    int addFollow(RelationShip relationShip);

    // 用户取消关注另一个用户
    int deleteFollow(RelationShip relationShip);

    // 获取单个用户的粉丝列表
    List<User> getFollowersList(int userId);

    // 获取单个用户的关注列表
    List<User> getFollowingList(int userId);

    // 获取单个用户的朋友列表
    List<User> getFriendsList(int userId);
}

//class User implements UserOperations {
//    // 实现接口中定义的方法
//    @Override
//    public void followUser(String userId, String followedUserId) {
//        // 实现用户关注逻辑
//    }
//
//    @Override
//    public void unfollowUser(String userId, String unfollowedUserId) {
//        // 实现用户取消关注逻辑
//    }
//
//    @Override
//    public List<String> getFollowersList(String userId) {
//        // 实现获取粉丝列表逻辑
//        return null;
//    }
//
//    @Override
//    public List<String> getFollowingList(String userId) {
//        // 实现获取关注列表逻辑
//        return null;
//    }
//
//    @Override
//    public List<String> getFriendsList(String userId) {
//        // 实现获取朋友列表逻辑
//        return null;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // 创建用户对象
//        User user = new User();
//
//        // 使用用户对象进行关注、取关、获取列表等操作
//        user.followUser("user1", "user2");
//        user.unfollowUser("user1", "user3");
//        List<String> followers = user.getFollowersList("user1");
//        List<String> following = user.getFollowingList("user1");
//        List<String> friends = user.getFriendsList("user1");
//    }
//}

