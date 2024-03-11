package lian;

import lian.search.*;
import lian.utils.MybatisUtils;
import lian.video.Video;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestSearch {

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        SearchMapper mapper = sqlSession.getMapper(SearchMapper.class);
        int userId= 1;

        lian.user.User user = mapper.searchUserById(userId);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getVideosByYear() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        SearchMapper mapper = sqlSession.getMapper(SearchMapper.class);
        int year = 2024;

        // 使用 selectList() 方法替代 selectOne()
        List<Video> videos = mapper.searchUserByYear(year);

        // 遍历并打印所有符合年份条件的视频记录
        for (Video video : videos) {
            System.out.println(video);
        }

        sqlSession.close();
    }
    @Test
    public void getVideosBytype() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        SearchMapper mapper = sqlSession.getMapper(SearchMapper.class);
        int year = 2024;

        // 使用 selectList() 方法替代 selectOne()
        List<Video> videos = mapper.searchUserByType("搞笑");

        // 遍历并打印所有符合年份条件的视频记录
        for (Video video : videos) {
            System.out.println(video);
        }

        sqlSession.close();
    }
}
