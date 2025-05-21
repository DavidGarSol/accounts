package com.midominio.accounts.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.midominio.accounts.repository.AccountRepository;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;

public class MyConfigurationClient {
	
//	@Bean
//	public RequestInterceptor requestInterceptor() {
//		return request -> {
//			request.header("Authorization", "auth");
//			
//		};
//	}
	

	@Bean
	public ErrorDecoder error() {
		return new CustomErrorDecoder();
	}

}
