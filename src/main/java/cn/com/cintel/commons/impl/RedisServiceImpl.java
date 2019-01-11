package cn.com.cintel.commons.impl;

import cn.com.cintel.commons.RedisService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Redis工具使用
 *
 * @author ZiQiang
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private JedisPool jedisPool;

    @Override
    public int hlen(List<String> keys) {
        if (keys.isEmpty()) {
            return 0;
        }
        Jedis jedis = jedis();
        Long hlen = 0L;
        for (String key : keys) {
            hlen += jedis.hlen(key);
        }
        close(jedis);
        return Integer.valueOf(hlen + "");
    }

    @Override
    public Integer sadd(String key, List<String> values) {
        Jedis jedis = jedis();
        Long length = 0L;
        for (String value : values) {
            length += jedis.sadd(key, value);
        }
        // 设置过期时间 为1天
        jedis.expire(key, 3600 * 24);
        close(jedis);
        return Integer.valueOf(length + "");
    }

    @Override
    public List<String> hKeys(List<String> keys) {
        Jedis jedis = jedis();
        List<String> list = new ArrayList<>();
        keys.forEach(key -> {
            String[] split = key.split("_");
            Set<String> fields = jedis.hkeys(key);
            for (String field : fields) {
                String value = field + "|" + split[0] + "|" + split[1];
                list.add(value);
            }
        });
        close(jedis);
        return list;
    }

    private Jedis jedis() {
        return jedisPool.getResource();
    }

    private void close(Jedis jedis) {
        jedis.close();
    }
}
