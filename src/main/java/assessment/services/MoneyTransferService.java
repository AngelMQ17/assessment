package assessment.services;
import assessment.repository.AccountRepository;
import assessment.dto.AccountDto;
import assessment.dto.MoneyTransferRequestDto;
import assessment.exception.AccountNotFoundException;
import assessment.exception.NotEnoughBalanceException;
import assessment.exception.SameAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MoneyTransferService {

    private final AccountRepository repository;

    @Autowired
    public MoneyTransferService(AccountRepository repository) {
        this.repository = repository;
    }

    public void sendMoneyBetweenAccounts(MoneyTransferRequestDto moneyTransferRequestDto) throws NotEnoughBalanceException {
        AccountDto senderAccount = repository.getReferenceById(moneyTransferRequestDto.getSenderAccountId());
        AccountDto receiverAccount = repository.getReferenceById(moneyTransferRequestDto.getReceiverAccountId());
        verifyAccounts(senderAccount, receiverAccount);
        updateSenderBalance(senderAccount, moneyTransferRequestDto);
        updateReceiverBalance(receiverAccount, moneyTransferRequestDto);
    }

    private static boolean amountIsPositive(AccountDto senderAccount, MoneyTransferRequestDto moneyTransferRequest) {
        return !(senderAccount.getAccountBalance().subtract(moneyTransferRequest.getAmount()).compareTo(BigDecimal.ZERO) < 0);
    }

    private void updateSenderBalance(AccountDto senderAccount, MoneyTransferRequestDto moneyTransferRequest) throws NotEnoughBalanceException {
        if(senderAccount.isTreasuryAccount() || amountIsPositive(senderAccount, moneyTransferRequest)) {
            repository.findById(senderAccount.getAccountId())
                    .map(account -> {
                        senderAccount.setAccountBalance(senderAccount.getAccountBalance().subtract(moneyTransferRequest.getAmount()));
                        return repository.save(account);
                    });
        }
        else {
            throw new NotEnoughBalanceException(senderAccount.getAccountId());
        }
    }

    private void updateReceiverBalance(AccountDto receiverAccount, MoneyTransferRequestDto moneyTransferRequest) {
        repository.findById(receiverAccount.getAccountId())
                .map(account -> {
                    receiverAccount.setAccountBalance(receiverAccount.getAccountBalance().add(moneyTransferRequest.getAmount()));
                    return repository.save(account);
                });
    }

    private void verifyAccounts(AccountDto senderAccount, AccountDto receiverAccount) {
        if (senderAccount == null) {
            throw new AccountNotFoundException();
        }
        if (receiverAccount == null) {
            throw new AccountNotFoundException();
        }
        if (senderAccount.getAccountId().equals(receiverAccount.getAccountId())) {
            throw new SameAccountException();
        }
    }
}