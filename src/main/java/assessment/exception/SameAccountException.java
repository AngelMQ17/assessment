package assessment.exception;

public class SameAccountException extends RuntimeException{
	private static final String MESSAGE = "Sender and Receiver Account should be different";

	public SameAccountException() {
		super(MESSAGE);
	}
}
