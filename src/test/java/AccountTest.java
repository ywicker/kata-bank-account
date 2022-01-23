import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    public void depositAnAmount() {
        Account account = new Account();
        account.deposit(1);
        assertThat(account.getBalance()).isEqualTo(1);
    }
}
