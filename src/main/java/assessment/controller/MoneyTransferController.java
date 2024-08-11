package assessment.controller;

import assessment.dto.MoneyTransferRequestDto;
import assessment.exception.NotEnoughBalanceException;
import assessment.services.MoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoneyTransferController {

	private final MoneyTransferService moneyTransferService;

	@Autowired
	public MoneyTransferController(MoneyTransferService moneyTransferService) {
		this.moneyTransferService = moneyTransferService;
	}

	@PostMapping("/send")
	public void transferMoneyBetweenAccounts(@RequestBody MoneyTransferRequestDto moneyTransferRequestDto) throws NotEnoughBalanceException {
		moneyTransferService.sendMoneyBetweenAccounts(moneyTransferRequestDto);
	}
}
