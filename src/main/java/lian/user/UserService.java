package lian.user;

import lian.SnowflakeIdWorker;
import lian.redis.JDBCUtils;
import lian.user.UserMapper;
import lian.jwt.*;
import lian.video.Video;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

abstract class UserService implements UserServiceInterface,UserMapper{
    @Override
    public String registerUser(String username, String password,String email,String avatar_url){
        int id;

            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                // 从连接池获取连接
                conn = JDBCUtils.getConnection();
                // 执行sql语句
                String sql = "INSERT INTO work4.user (userid,username, password, email, avatar_url) VALUES (?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
                id = (int)idWorker.nextId();
                // 设定sql语句的参数
                pstmt.setInt(1,id);
                pstmt.setString(2,username);
                pstmt.setString(3,password);
                pstmt.setString(4,email);
                pstmt.setString(5,avatar_url);
            } catch (Exception e) {

                // 更具体地捕获并处理SQL异常，而不是笼统地返回null
                throw new RuntimeException("Failed to upload user by ID due to SQL Exception", e);
            } finally {
                JDBCUtils.close(rs, pstmt, conn);
            }
        ControllerDemo controllerDemo = new ControllerDemo();
        HttpServletRequest httpServletRequest = null;
        controllerDemo.getJwtToken(httpServletRequest);
            return "注册成功！";
    }

    @Override
    public String login(int userid,String password) {
        int id;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 从连接池获取连接
            conn = JDBCUtils.getConnection();
            // 执行sql语句
            String sql = "SELECT password FROM users WHERE id =?";
            pstmt = conn.prepareStatement(sql);
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            id = (int)idWorker.nextId();
            // 设定sql语句的参数
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if (rs.getString("password").equals(password)){
                ControllerDemo controllerDemo = new ControllerDemo();
                HttpServletRequest httpServletRequest = null;
                controllerDemo.getJwtToken(httpServletRequest);
                return "登录成功";
            }
        } catch (Exception e) {

            // 更具体地捕获并处理SQL异常，而不是笼统地返回null
            throw new RuntimeException("Failed to upload user by ID due to SQL Exception", e);
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return "登录失败";
    }


}
