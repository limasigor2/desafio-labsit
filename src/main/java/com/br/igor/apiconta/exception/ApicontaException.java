package com.br.igor.apiconta.exception;

import org.springframework.http.HttpStatus;

import com.br.igor.apiconta.dto.MessageDTO;

public class ApicontaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -177202544137485850L;

	private MessageDTO message;
	private HttpStatus status;

	public ApicontaException(HttpStatus status, String key, String message) {
		this.status = status;
		this.message = new MessageDTO(message, key);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public MessageDTO getMessageAsObject() {
		return message;
	}

}
