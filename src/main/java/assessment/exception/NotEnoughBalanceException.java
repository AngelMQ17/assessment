package assessment.exception;


public class NotEnoughBalanceException extends Exception{

	private static final String MESSAGE = "Account with accountId=%s cannot have a negative balance as is not a Treasury Account";

	public NotEnoughBalanceException(Long id) {
		super(String.format(MESSAGE, id));
	}
}
