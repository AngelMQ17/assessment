package assessment.angelmq;

import assessment.controller.AccountController;
import assessment.controller.MoneyTransferController;
import assessment.dto.AccountDto;
import assessment.dto.MoneyTransferRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Currency;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class MoneyTransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoneyTransferController moneyTransferController;


    //TODO Fix failing test
//	@Test
//	@DisplayName("POST /send - Send Money Between accounts")
//	public void testTransferMoney() throws Exception {
//		AccountDto senderAccount = new AccountDto("Sender", Currency.getInstance("EUR"), new BigDecimal("100.00"), true);
//		AccountDto receiverAccount = new AccountDto("Receiver", Currency.getInstance("EUR"), new BigDecimal("100.00"), true);
//		MoneyTransferRequestDto moneyTransferRequest = new MoneyTransferRequestDto(senderAccount.getAccountId(), receiverAccount.getAccountId(), BigDecimal.valueOf(10));
//		when(moneyTransferController.transferMoneyBetweenAccounts(moneyTransferRequest))
//				.
//		mockMvc.perform(post("/accounts")
//				.content("{\"accountName\":\"TEST\",\"accountCurrency\":\"EUR\",\"accountBalance\":300.00,\"isTreasuryAccount\":true}\"")
//				.contentType(APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}
}