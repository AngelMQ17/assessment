package assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class NotEnoughBalanceExceptionHandler {

	@ExceptionHandler(NotEnoughBalanceException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	String notEnoughBalanceHandler(NotEnoughBalanceException ex) {
		return ex.getMessage();
	}
}
