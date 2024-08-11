package assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class SameAccountExceptionHandler {

	@ExceptionHandler(SameAccountException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	String sameAccountExceptionHandler(SameAccountException ex) {
		return ex.getMessage();
	}
}
