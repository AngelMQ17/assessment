package assessment.exception;

public class AccountNotFoundException extends RuntimeException{
	private static final String MESSAGE = "Account not found";

	public AccountNotFoundException() {
		super(MESSAGE);
	}
}
