package com.REST_API.rset_api.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.REST_API.rset_api.DTO.ErrorDto;
import com.REST_API.rset_api.DTO.ResponseDto;

import lombok.AllArgsConstructor;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DataExistsException.class)
	@ResponseStatus(value=HttpStatus.CONFLICT)
	public ErrorDto handle(DataExistsException exception) {
		return new ErrorDto(exception.getMessage()) ;
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(value=HttpStatus.CONFLICT)
	public ErrorDto handle(DataNotFoundException exception) {
		return new ErrorDto(exception.getMessage()) ;
	}

}
