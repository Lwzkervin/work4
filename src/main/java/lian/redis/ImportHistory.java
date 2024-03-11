package lian.redis;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lian.video.Video;
import lian.search.*;

public class ImportHistory {
    public static void importHistory(int paramUid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 从连接池获取连接
            conn = JDBCUtils.getConnection();
            // 执行sql语句
            String sql = "SELECT * FROM work4.searchhistory";
            pstmt = conn.prepareStatement(sql);
            // 设定sql语句的参数
            pstmt.setInt(1, paramUid);
            // 返回结果集
            rs = pstmt.executeQuery();

            if (rs.next()) {
                SearchHistory searchHistory = new SearchHistory();
                searchHistory.userId= rs.getInt("videoId");
                searchHistory.searchKeyword = rs.getString("videoUrl");
            } else {
                System.out.printf("不太行没有能传的!\n");
                // 当查询结果不存在时，可以返回null，也可以考虑抛出一个自定义异常或返回一个默认值
            }

        } catch (Exception e) {
            // 更具体地捕获并处理SQL异常，而不是笼统地返回null
            throw new RuntimeException("Failed to import search history due to SQL Exception", e);
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
    }
}
