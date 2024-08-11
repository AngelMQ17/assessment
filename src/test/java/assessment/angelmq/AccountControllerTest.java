package assessment.angelmq;

import assessment.controller.AccountController;
import assessment.dto.AccountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountController accountController;

	@Test
	@DisplayName("GET /accounts - Get full account list")
	public void testGetAllAccounts() throws Exception {
		AccountDto account_1 = new AccountDto("Test 1", Currency.getInstance("EUR"), new BigDecimal("100.00"), true);
		AccountDto account_2 = new AccountDto("Test 2", Currency.getInstance("USD"), new BigDecimal("200.00"), false);
		List<AccountDto> accountDtoList = Arrays.asList(account_1, account_2);

		when(accountController.getAllAccounts()).thenReturn(ResponseEntity.ok(accountDtoList));

		mockMvc.perform(get("/accounts"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)));
	}

	@Test
	@DisplayName("GET /accounts/{id} - Get Account by Id")
	public void testGetAccountById() throws Exception {
		AccountDto account_1 = new AccountDto("Test 1", Currency.getInstance("EUR"), new BigDecimal("100.00"), true);
		account_1.setAccountId(Long.valueOf(1));

		when(accountController.getAccountById(account_1.getAccountId())).thenReturn(ResponseEntity.ok(account_1));

		mockMvc.perform(get("/accounts/{id}", account_1.getAccountId()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.accountName").value("Test 1"));
	}
}