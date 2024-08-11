package assessment.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Currency;

@Entity
public class AccountDto {

	@Id
	@GeneratedValue
	private Long accountId;

	private String accountName;
	private Currency accountCurrency;

	private BigDecimal accountBalance;

	private boolean isTreasuryAccount;

	public AccountDto() {}

	public AccountDto(String accountName, Currency accountCurrency, BigDecimal accountBalance, boolean isTreasuryAccount) {
		this.accountName = accountName;
		this.accountCurrency = accountCurrency;
		this.accountBalance = accountBalance;
		this.isTreasuryAccount = isTreasuryAccount;
	}

	public Long getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public Currency getAccountCurrency() {
		return accountCurrency;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public boolean isTreasuryAccount() {
		return isTreasuryAccount;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setAccountCurrency(Currency accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
}
