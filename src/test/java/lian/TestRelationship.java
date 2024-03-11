package lian;


import lian.relationship.RelationShip;
import lian.relationship.*;
import lian.user.User;
import lian.user.UserMapper;
import lian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
public class TestRelationship {

    @Test
    public void addrelationship() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RelationShipMapper mapper = sqlSession.getMapper(RelationShipMapper.class);

        int res = mapper.addFollow(new RelationShip(2, 3));
        if (res > 0) {
            System.out.println("插入关系成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleterelationship() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RelationShipMapper mapper = sqlSession.getMapper(RelationShipMapper.class);

        int res = mapper.deleteFollow(new RelationShip(1, 4));
        if (res > 0) {
            System.out.println("删除关系成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testGetFollowersByUserId() {
        // 获取数据库会话
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 获取关系映射器
        RelationShipMapper mapper = sqlSession.getMapper(RelationShipMapper.class);

        int userId = 3; // 指定要查询粉丝列表的用户ID

        // 通过映射器获取指定用户的粉丝列表
        List<User> followers = mapper.getFollowersList(userId);

        if (followers != null && !followers.isEmpty()) {
            System.out.println("用户 " + userId + " 的粉丝列表：");
            for (User follower : followers){

                // 打印粉丝的信息
                System.out.println(follower);
                // 可以根据需要打印更多粉丝信息
            }
        } else {
            System.out.println("用户 " + userId + " 暂无粉丝。");
        }

        // 关闭数据库会话
        sqlSession.close();
    }

    @Test
    public void testgetFollowingList() {
        // 获取数据库会话
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 获取关系映射器
        RelationShipMapper mapper = sqlSession.getMapper(RelationShipMapper.class);

        int userId = 1; // 指定要查询粉丝列表的用户ID

        // 通过映射器获取指定用户的粉丝列表
        List<User> followers = mapper.getFollowingList(userId);

        if (followers != null && !followers.isEmpty()) {
            System.out.println("用户 " + userId + " 的关注列表：");
            for (User follower : followers){

                // 打印粉丝的信息
                System.out.println(follower);
                // 可以根据需要打印更多粉丝信息
            }
        } else {
            System.out.println("用户 " + userId + " 暂无关注。");
        }

        // 关闭数据库会话
        sqlSession.close();
    }

    @Test
    public void getFriendsList() {
        // 获取数据库会话
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 获取关系映射器
        RelationShipMapper mapper = sqlSession.getMapper(RelationShipMapper.class);

        int userId = 1; // 指定要查询粉丝列表的用户ID

        // 通过映射器获取指定用户的粉丝列表
        List<User> followers = mapper.getFriendsList(userId);

        if (followers != null && !followers.isEmpty()) {
            System.out.println("用户 " + userId + " 的朋友列表：");
            for (User follower : followers){

                // 打印粉丝的信息
                System.out.println(follower);
                // 可以根据需要打印更多粉丝信息
            }
        } else {
            System.out.println("用户 " + userId + " 暂无朋友。");
        }

        // 关闭数据库会话
        sqlSession.close();
    }
}

