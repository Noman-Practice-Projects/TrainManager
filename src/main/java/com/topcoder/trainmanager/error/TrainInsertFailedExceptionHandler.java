package com.topcoder.trainmanager.error;

import com.topcoder.trainmanager.dto.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type Train exception handler.
 */
@ControllerAdvice
public class TrainInsertFailedExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Custom handle not found response train.
	 *
	 * @return the response entity
	 */
	@ExceptionHandler (TrainInsertFailedException.class)
	public ResponseEntity<GenericResponse> customHandleNotFound() {
		return new ResponseEntity<>(new GenericResponse("failed validation", null), HttpStatus.BAD_REQUEST);
	}
	
}
