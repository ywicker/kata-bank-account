import org.junit.jupiter.api.Test;

import static kata.bank.account.Amount.createAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {
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


}
