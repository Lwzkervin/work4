package lian.redis;

import lian.video.Video;

import java.util.Set;


public class Rank {
    public static void main(String[] args) {
        //循环persons表中的每一行数据，添加到redis中的有序集合中
        for (int i = 1; i <= 3; i++) {
            Video video = MysqlConn.getUserByUid(i);
            RedisConn.addToRank(video.description, video.viewsCount);
        }

        Set<String> rankSet = null;

        //从redis的有序集合中按分数递减顺序返回排序好的成员集合
        rankSet = RedisConn.getRank();

        System.out.println(rankSet);
        rankSet.clear();
        return;
    }
}




