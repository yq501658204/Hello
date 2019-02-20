package com.example.Hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis测试
 * @author YQ13512
 *
 */
@RestController
public class RedisController {

	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate; 
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/redis")
	public String redisTest(){
		ValueOperations<String,Object> jedis = redisTemplate.opsForValue();
		jedis.set("conpany", "bbaidu");
		return "OJBK";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getRedis")
	public String getRedis(){
		ValueOperations<String,Object> jedis = redisTemplate.opsForValue();
		String company = (String) jedis.get("conpany");
		return company;
	}
	
}
