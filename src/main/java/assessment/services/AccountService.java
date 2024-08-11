package assessment.services;

import assessment.exception.AccountNotFoundException;
import assessment.repository.AccountRepository;
import assessment.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<AccountDto> getAllAccounts() {
        return repository.findAll();
    }

    public AccountDto getAccountById(Long id) {
        return repository.findById(id)
                .orElseThrow(AccountNotFoundException::new);
    }

    public AccountDto createNewAccount(AccountDto newAccountDto) {
        return repository.save(newAccountDto);
    }

    public AccountDto updateAccount(AccountDto newAccountDataDto, Long id) {
        return repository.findById(id)
                .map(accountDto -> {
                    accountDto.setAccountName(newAccountDataDto.getAccountName());
                    accountDto.setAccountCurrency(newAccountDataDto.getAccountCurrency());
                    accountDto.setAccountBalance(newAccountDataDto.getAccountBalance());
                    return repository.save(accountDto);
                })
                .orElseGet(() -> repository.save(newAccountDataDto));
    }
}
