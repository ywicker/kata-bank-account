import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static kata.bank.account.Amount.createAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void depositAnAmount() {
        Account account = new Account();
        account.deposit(createAmount(1));
        assertThat(account.getBalance()).isEqualTo(1);
    }
    @Test
    public void depositTwoAmount() {
        Account account = new Account();
        account.deposit(createAmount(1));
        account.deposit(createAmount(1));
        assertThat(account.getBalance()).isEqualTo(2);
    }
    @Test
    public void depositZero() {
        Account account = new Account();
        assertThatThrownBy(() ->
                account.deposit(createAmount(0))
        ).isInstanceOf(AssertionError.class);
    }
    @Test
    public void depositNegativeAmount() {
        Account account = new Account();
        assertThatThrownBy(() ->
                account.deposit(createAmount(-1))
        ).isInstanceOf(AssertionError.class);
    }

    @Test
    public void withdrawalAnAmount() {
        Account account = new Account();
        account.withdrawal(createAmount(1));
        assertThat(account.getBalance()).isEqualTo(-1);
    }
    @Test
    public void withdrawalTwoAmount() {
        Account account = new Account();
        account.withdrawal(createAmount(1));
        account.withdrawal(createAmount(1));
        assertThat(account.getBalance()).isEqualTo(-2);
    }
    @Test
    public void withdrawalZero() {
        Account account = new Account();
        assertThatThrownBy(() ->
                account.withdrawal(createAmount(0))
        ).isInstanceOf(AssertionError.class);
    }
    @Test
    public void withdrawalNegativeAmount() {
        Account account = new Account();
        assertThatThrownBy(() ->
                account.withdrawal(createAmount(-1))
        ).isInstanceOf(AssertionError.class);
    }

    @Test
    public void generateAccountStatementWithoutOperation() throws ParseException {
        Account account = new Account();
        assertThat(
                account.generateAccountStatement(
                        dateFormat.parse("2021-01-01 00:00:00"),
                        dateFormat.parse("2022-01-01 00:00:00"))
        ).hasSize(0);
    }
    @Test
    public void generateAccountStatementWithOneOperation() throws ParseException {
        Account account = new Account();
        account.deposit(createAmount(1));
        assertThat(
                account.generateAccountStatement(
                        dateFormat.parse("2021-01-01 00:00:00"),
                        dateFormat.parse("2022-01-01 00:00:00"))
        ).hasSize(1);
    }
}
