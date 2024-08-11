package assessment.services;

import assessment.repository.AccountRepository;
import assessment.dto.AccountDto;
import assessment.dto.MoneyTransferRequestDto;
import assessment.exception.AccountNotFoundException;
import assessment.exception.NotEnoughBalanceException;
import assessment.exception.SameAccountException;

import java.math.BigDecimal;

public class MoneyTransferService {

    private final AccountRepository repository;

    public MoneyTransferService(AccountRepository repository) {
        this.repository = repository;
    }

    public void sendMoneyBetweenAccounts(MoneyTransferRequestDto moneyTransferRequestDto) throws NotEnoughBalanceException {
        AccountDto senderAccount = repository.getReferenceById(moneyTransferRequestDto.getSenderAccountId());
        AccountDto receiverAccount = repository.getReferenceById(moneyTransferRequestDto.getReceiverAccountId());
        if(senderAccount == null || receiverAccount == null) {
            throw new AccountNotFoundException();
        }
        if(senderAccount.getAccountId().equals(receiverAccount.getAccountId())) {
            throw new SameAccountException();
        }
        if(senderAccount.isTreasuryAccount() || !(senderAccount.getAccountBalance().subtract(moneyTransferRequestDto.getAmount()).compareTo(BigDecimal.ZERO) < 0)) {
            repository.findById(senderAccount.getAccountId())
                    .map(account -> {
                        senderAccount.setAccountBalance(senderAccount.getAccountBalance().subtract(moneyTransferRequestDto.getAmount()));
                        return repository.save(account);
                    });
        }
        else {
            throw new NotEnoughBalanceException(senderAccount.getAccountId());
        }

        repository.findById(receiverAccount.getAccountId())
                .map(account -> {
                    receiverAccount.setAccountBalance(receiverAccount.getAccountBalance().add(moneyTransferRequestDto.getAmount()));
                    return repository.save(account);
                });
    }
}
