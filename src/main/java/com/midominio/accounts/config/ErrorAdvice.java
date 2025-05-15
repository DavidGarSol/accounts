package com.midominio.accounts.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.midominio.accounts.exception.UnauthorizedException;
import com.midominio.accounts.model.ErrorResponse;
import com.midominio.accounts.model.ErrorType;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorAdvice {
	
	@ExceptionHandler(exception = UnauthorizedException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public ErrorResponse handlerUnauthorizedException(
			HttpServletRequest req, UnauthorizedException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setCode(HttpStatus.UNAUTHORIZED.value());
		error.setDetails(ex.getMessage());
		error.setLocation(req.getRequestURI());
		error.setMessage(ex.getStackTrace().toString());
		error.setType(ErrorType.ERROR);
		
		return error;
	}

}
