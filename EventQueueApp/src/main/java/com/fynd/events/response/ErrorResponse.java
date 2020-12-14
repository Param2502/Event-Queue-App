package com.fynd.events.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private String errorMessage;
	
	private Date errorDate;
	
	private Integer statusCode;
}
