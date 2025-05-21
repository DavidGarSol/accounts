package com.midominio.accounts.session;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.midominio.accounts.exception.UnauthorizedException;

@Component
public class SessionManagmentImpl implements SessionManagment {
	
	private static final Logger LOG = LoggerFactory.getLogger(SessionManagmentImpl.class);
	
    @Autowired
    @Qualifier("redisCacheTest")
    private RedisTemplate<String, String> redis;
    
	@Override
	public String getValueByKey(String key) {
		LOG.info("Obteniendo datos en redis");
    	String value = redis.opsForValue().get(key);
    	LOG.info("Is null? " + value);
    	if (Objects.isNull(value)) throw new UnauthorizedException("NO SESSION");
    	
		return value;
	}

}
