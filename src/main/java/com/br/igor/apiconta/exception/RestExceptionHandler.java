package com.br.igor.apiconta.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageDTO(
				"Erro ao salvar informações, provavelmente informações já cadastradas no banco, tente novamente com outras informações",
				"error.probably.duplicated-value"));
	}
//	@ExceptionHandler(Exception.class)
//	protected ResponseEntity<?> handleException(Exception ex) {
//		ex.printStackTrace();
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageDTO(
//				"Erro desconhecido, contate o administrador",
//				"internal.server.error"));
//	}

	private ResponseEntity<?> buildResponseEntity(ApicontaException apicontaException) {
		return ResponseEntity.status(apicontaException.getStatus()).body(apicontaException.getMessageAsObject());
	}
}
