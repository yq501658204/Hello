package com.example.Hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)//设置session失效时间
public class SessionConfig {
	
	/*@Bean
	public JedisConnectionFactory connectionFactory() { 
		return new JedisConnectionFactory(); 
	} */
}
