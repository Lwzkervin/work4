package lian.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisConn {
    //添加成员到有序集合
    public static void addToRank(String description, int viewsCount) {
        Jedis jedis = RedisUtils.getJedis();
        jedis.zadd("rank", viewsCount, description);
        jedis.close();
    }

    //从有序集合中获取按分数递减排序的成员集合
    public static Set<String> getRank() {
        Jedis jedis = RedisUtils.getJedis();
        Set<String> rankSet = jedis.zrevrange("rank", 0, -1);
        jedis.close();
        return rankSet;
    }
}

