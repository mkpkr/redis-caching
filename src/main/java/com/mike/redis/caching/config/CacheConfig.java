package com.mike.redis.caching.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@EnableCaching
public class CacheConfig {
	
	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
	    return RedisCacheConfiguration.defaultCacheConfig()
								      .entryTtl(Duration.ofMinutes(1))
								      .disableCachingNullValues();
//	      .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}
	
	@Bean
	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
	    return (builder) -> builder
	      .withCacheConfiguration("timeCache", RedisCacheConfiguration.defaultCacheConfig());
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost", 30004);
	    return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

}
