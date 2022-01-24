import kata.bank.account.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static kata.bank.account.Amount.createAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

public class AccountTest {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final DateProvider dateProvider = new DefaultDateProvider();
    @Mock
    private DateProvider mockDateProvider;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void depositAnAmount() {
        Account account = new Account(dateProvider);
        account.deposit(createAmount(1));
        assertThat(account.getBalance()).isEqualTo(1);
    }
    @Test
    public void depositTwoAmount() {
        Account account = new Account(dateProvider);
        account.deposit(createAmount(1));
        account.deposit(createAmount(1));
        assertThat(account.getBalance()).isEqualTo(2);
    }
    @Test
    public void depositZero() {
        Account account = new Account(dateProvider);
        assertThatThrownBy(() ->
                account.deposit(createAmount(0))
        ).isInstanceOf(AssertionError.class);
    }
    @Test
    public void depositNegativeAmount() {
        Account account = new Account(dateProvider);
        assertThatThrownBy(() ->
                account.deposit(createAmount(-1))
        ).isInstanceOf(AssertionError.class);
    }

    @Test
    public void withdrawalAnAmount() {
        Account account = new Account(dateProvider);
        account.withdrawal(createAmount(1));
        assertThat(account.getBalance()).isEqualTo(-1);
    }
    @Test
    public void withdrawalTwoAmount() {
        Account account = new Account(dateProvider);
        account.withdrawal(createAmount(1));
        account.withdrawal(createAmount(1));
        assertThat(account.getBalance()).isEqualTo(-2);
    }
    @Test
    public void withdrawalZero() {
        Account account = new Account(dateProvider);
        assertThatThrownBy(() ->
                account.withdrawal(createAmount(0))
        ).isInstanceOf(AssertionError.class);
    }
    @Test
    public void withdrawalNegativeAmount() {
        Account account = new Account(dateProvider);
        assertThatThrownBy(() ->
                account.withdrawal(createAmount(-1))
        ).isInstanceOf(AssertionError.class);
    }

    @Test
    public void generateAccountStatementWithoutOperation() throws ParseException {
        Account account = new Account(dateProvider);
        assertThat(
                account.generateAccountStatement(
                        dateFormat.parse("2021-01-01 00:00:00"),
                        dateFormat.parse("2022-01-01 00:00:00"))
        ).hasSize(0);
    }
    @Test
    public void generateAccountStatementWithOneOperation() throws ParseException {
        when(mockDateProvider.getDate())
                .thenReturn(dateFormat.parse("2021-01-01 11:00:00"));
        Account account = new Account(mockDateProvider);
        account.deposit(createAmount(1));
        assertThat(
                account.generateAccountStatement(
                        dateFormat.parse("2021-01-01 00:00:00"),
                        dateFormat.parse("2022-01-01 00:00:00"))
        ).hasSize(1)
                .containsExactly(new Operation(
                        dateFormat.parse("2021-01-01 11:00:00")
                        , createAmount(1)
                        , OperationType.DEPOSIT));
    }
}
