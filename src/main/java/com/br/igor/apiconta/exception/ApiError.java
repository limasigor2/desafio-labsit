package com.br.igor.apiconta.exception;

import java.util.Arrays;
import java.util.List;


public class ApiError {

	private String message;
	private List<String> errors;

	public ApiError(String message, List<String> errors) {
		super();
		this.message = message;
		this.errors = errors;
	}

	public ApiError(String message, String error) {
		super();
		this.message = message;
		errors = Arrays.asList(error);
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}