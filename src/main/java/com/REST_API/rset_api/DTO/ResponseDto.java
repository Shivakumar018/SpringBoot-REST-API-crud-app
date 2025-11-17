package com.REST_API.rset_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
	private String message;
	private Object obj;
}
