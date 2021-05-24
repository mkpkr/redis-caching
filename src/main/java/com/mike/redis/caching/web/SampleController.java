package com.mike.redis.caching.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mike.redis.caching.application.CachingService;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	CachingService cachingService;
	
	@GetMapping("/message")
	public ResponseEntity<String> get() {
		return ResponseEntity.ok(cachingService.getSomething());
	}

}
