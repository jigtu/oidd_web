package cn.com.cintel.commons;

import java.util.List;

/**
 * @author ZiQiang
 */
public interface RedisService {
    /**
     * 获取当前key下面的所有field
     *
     * @param keys key 集合
     * @return 结果
     */
    int hlen(List<String> keys);

    /**
     * 号码池生成
     *
     * @param key    set key
     * @param values value
     */
    Integer sadd(String key, List<String> values);

    /**
     * 获取所有哈希表中的字段
     *
     * @param keys keys
     * @return 字段集合
     */
    List<String> hKeys(List<String> keys);
}
