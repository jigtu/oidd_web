package cn.com.cintel.commons.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis 的集群以及单机模式配置类
 * 1、使用单机模式 将jedisCluster 方法的@Bean注解注销
 * 2、使用集群模式 将jedisPool    方法的@Bean注解注销
 * 将cluster的@Value注解打开 其余的注销
 *
 * @author ZiQiang
 */
@Configuration
public class RedisConfig {
    private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.maxTotal}")
    private Integer maxTotal;
    @Value("${spring.redis.maxIdle}")
    private Integer maxIdle;
    @Value("${spring.redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;
    @Value("${spring.redis.maxWaitMillis}")
    private Integer maxWaitMillis;
    @Value("${spring.redis.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.redis.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.redis.blockWhenExhausted}")
    private boolean blockWhenExhausted;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, false);
        logger.info("JedisPool注入成功！！" + "Redis地址 " + host + ":" + port);
        return jedisPool;
    }
}
