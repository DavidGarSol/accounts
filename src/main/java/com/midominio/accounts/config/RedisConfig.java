package com.midominio.accounts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
	
	@Bean
	LettuceConnectionFactory lettuceConnectionFactory() {
		LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
		connectionFactory.afterPropertiesSet();
		return connectionFactory;
	}


	@Bean("redisCacheTest")
	public RedisTemplate<String, String> redisTemplateString() {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(lettuceConnectionFactory());
		template.setDefaultSerializer(StringRedisSerializer.UTF_8);
		template.afterPropertiesSet();
		
	    return template;
	}

}