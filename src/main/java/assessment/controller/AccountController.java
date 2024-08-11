package assessment.controller;

import assessment.dto.AccountDto;
import assessment.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

	private final AccountService accountService;

	@Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountList = accountService.getAllAccounts();
		return ResponseEntity.ok(accountList);
	}

	@GetMapping("/accounts/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		AccountDto account = accountService.getAccountById(id);
		return ResponseEntity.ok(account);
	}

	@PostMapping("/accounts")
	public ResponseEntity<AccountDto> newAccount(@RequestBody AccountDto newAccountDto) {
		AccountDto newAccount = accountService.createNewAccount(newAccountDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
	}

	@PutMapping("/accounts/{id}")
	public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto newAccountDataDto, @PathVariable Long id) {
		AccountDto updatedAccount = accountService.updateAccount(newAccountDataDto, id);
		return ResponseEntity.ok(updatedAccount);
	}
}
