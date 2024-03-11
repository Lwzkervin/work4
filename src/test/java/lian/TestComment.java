package lian;

import lian.comment.*;
import lian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestComment {

    @Test
    public void addcomment() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);

        int res = mapper.addComment(new Comment(2,2,"666啊家人们"));
        if (res > 0) {
            System.out.println("插入评论成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void replycomment() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);

        int res = mapper.replyComment(new Comment(2,2,"666啊家人们",3));
        if (res > 0) {
            System.out.println("插入评论成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }
}
