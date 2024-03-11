package lian.redis;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lian.redis.JDBCUtils;
import lian.video.Video;
import java.time.LocalDateTime;

public class MysqlConn {
    public static Video getUserByUid(int paramUid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 从连接池获取连接
            conn = JDBCUtils.getConnection();
            // 执行sql语句
            String sql = "select * from work4.video where videoId = ?";
            pstmt = conn.prepareStatement(sql);
            // 设定sql语句的参数
            pstmt.setInt(1, paramUid);
            // 返回结果集
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Video video = new Video();
                video.videoId = rs.getInt("videoId");
                video.videoUrl = rs.getString("videoUrl");
                video.description = rs.getString("description");
//                video.uploadTime = rs.getObject("uploadTime", LocalDateTime.class);
                video.viewsCount = rs.getInt("viewsCount");
                video.userId = rs.getInt("userId");

                System.out.println(video);
                return video;
            } else {
                System.out.printf("不太行没找到!\n");
                // 当查询结果不存在时，可以返回null，也可以考虑抛出一个自定义异常或返回一个默认值
                return null;
            }

        } catch (Exception e) {
            // 更具体地捕获并处理SQL异常，而不是笼统地返回null
            throw new RuntimeException("Failed to get video by ID due to SQL Exception", e);
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
    }
}
