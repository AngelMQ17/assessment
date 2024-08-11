package assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class AccountNotFoundExceptionHandler {

	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String accountNotFoundHandler(AccountNotFoundException ex) {
		return ex.getMessage();
	}
}
