import kata.bank.account.Amount;
import kata.bank.account.Operation;

import java.util.Date;
import java.util.List;

public class Account {
    private int balance;

    public Account() {
        this.balance = 0;
    }

    public void deposit(final Amount amount) {
        balance += amount.getValue();
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawal(final Amount amount) {
        balance -= amount.getValue();
    }

    public List<Operation> generateAccountStatement(final Date startDate, final Date endDate) {
        return List.of();
    }
}
