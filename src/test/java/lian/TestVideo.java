package lian;

import lian.search.SearchMapper;
import lian.video.*;
import lian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestVideo {

    @Test
    public void addVideo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);

        int res = mapper.uploadVideo(new Video(3, "http:abcdefg","这是第一条测试视频",1));
        if (res > 0) {
            System.out.println("插入关系成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testview() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);

        int res = mapper.viewVideo(2);
        if (res > 0) {
            System.out.println("访问视频成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testdelete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);

        int res = mapper.deleteVideoById(2);
        res+=mapper.deleteCommentsByVideoId(2);
        if (res > 1) {
            System.out.println("删除视频成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }
@Test
    public void getVideosBysort() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);

        // 使用 selectList() 方法替代 selectOne()
        List<Video> videos = mapper.sortByViewsCount();

        // 遍历并打印所有符合年份条件的视频记录
        for (Video video : videos) {
            System.out.println(video);
        }

        sqlSession.close();
    }

    @Test
    public void getVideosBydate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);

        // 使用 selectList() 方法替代 selectOne()
        List<Video> videos = mapper.sortByuploadTime();

        // 遍历并打印所有符合年份条件的视频记录
        for (Video video : videos) {
            System.out.println(video);
        }

        sqlSession.close();
    }
}
