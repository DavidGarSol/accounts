package com.midominio.accounts.client;

import java.io.IOException;

import com.midominio.accounts.exception.ForbiddenException;
import com.midominio.accounts.exception.UnauthorizedException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		
		switch (response.status()){
	        case 400:
	            return new ForbiddenException();
	        case 401:
	            return new UnauthorizedException();
	        default:
	            return new Exception("Generic error");
	    }
	}

}
