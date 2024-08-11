package assessment.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class MoneyTransferRequestDto {

	@Id
	@GeneratedValue
	private Long orderId;
	private Long senderAccountId;
	private Long receiverAccountId;
	private BigDecimal amount;

	public Long getSenderAccountId() {
		return senderAccountId;
	}

	public Long getReceiverAccountId() {
		return receiverAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

}
