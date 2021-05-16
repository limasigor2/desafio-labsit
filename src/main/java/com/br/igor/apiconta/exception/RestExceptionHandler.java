package com.br.igor.apiconta.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.igor.apiconta.dto.MessageDTO;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApicontaException.class)
	protected ResponseEntity<?> handleValidcException(ApicontaException ex) {
		return buildResponseEntity(ex);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	protected ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageDTO(
				"Erro ao salvar informações, provavelmente informações já cadastradas no banco, tente novamente com outras informações",
				"error.probably.duplicated-value"));
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<?> handleException(Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new MessageDTO("Erro desconhecido, contate o administrador", "internal.server.error"));
	}

	private ResponseEntity<?> buildResponseEntity(ApicontaException apicontaException) {
		apicontaException.printStackTrace();
		return ResponseEntity.status(apicontaException.getStatus()).body(apicontaException.getMessageAsObject());
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getDefaultMessage());
		}

		ApiError apiError = new ApiError(ex.getMessage(), errors);
		return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
	}
}
