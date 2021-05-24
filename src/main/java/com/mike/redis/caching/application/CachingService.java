package com.mike.redis.caching.application;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachingService {

	@Cacheable("time-cache")
	public String getSomething() {
		return "time=" + System.currentTimeMillis();
	}
	
	

}
