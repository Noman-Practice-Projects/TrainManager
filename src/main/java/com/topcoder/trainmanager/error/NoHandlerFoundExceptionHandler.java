package com.topcoder.trainmanager.error;

import com.topcoder.trainmanager.dto.GenericResponse;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type Train exception handler.
 */
@ControllerAdvice
public class NoHandlerFoundExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected @NonNull ResponseEntity<Object> handleNoHandlerFoundException(@NonNull NoHandlerFoundException ex, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {
		return new ResponseEntity<>(new GenericResponse("invalid endpoint", null), HttpStatus.METHOD_NOT_ALLOWED);
	}
}
