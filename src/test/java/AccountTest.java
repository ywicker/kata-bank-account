import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {
    @Test
    public void depositAnAmount() {
        Account account = new Account();
        account.deposit(1);
        assertThat(account.getBalance()).isEqualTo(1);
    }
    @Test
    public void depositTwoAmount() {
        Account account = new Account();
        account.deposit(1);
        account.deposit(1);
        assertThat(account.getBalance()).isEqualTo(2);
    }
    @Test
    public void depositZero() {
        Account account = new Account();
        assertThatThrownBy(() ->
                account.deposit(0)
        ).isInstanceOf(AssertionError.class);
    }
    @Test
    public void depositNegativeAmount() {
        Account account = new Account();
        assertThatThrownBy(() ->
                account.deposit(-1)
        ).isInstanceOf(AssertionError.class);
    }

    @Test
    public void withdrawalAnAmount() {
        Account account = new Account();
        account.withdrawal(1);
        assertThat(account.getBalance()).isEqualTo(-1);
    }
    @Test
    public void withdrawalTwoAmount() {
        Account account = new Account();
        account.withdrawal(1);
        account.withdrawal(1);
        assertThat(account.getBalance()).isEqualTo(-2);
    }
    @Test
    public void withdrawalZero() {
        Account account = new Account();
        assertThatThrownBy(() ->
                account.withdrawal(0)
        ).isInstanceOf(AssertionError.class);
    }
}
