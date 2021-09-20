package com.topcoder.bullettrain.error;

import com.topcoder.bullettrain.dto.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type Train exception handler.
 */
@ControllerAdvice
public class TrainNotFoundExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Custom handle not found response train.
	 *
	 * @return the response entity
	 */
	@ExceptionHandler (TrainNotFoundException.class)
	public ResponseEntity<GenericResponse> customHandleNotFound() {
		return new ResponseEntity<>(new GenericResponse("train not found", null), HttpStatus.NOT_FOUND);
	}
	
}
