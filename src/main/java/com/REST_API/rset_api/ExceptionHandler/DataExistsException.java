package com.REST_API.rset_api.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataExistsException extends RuntimeException{
	private String message;

}
