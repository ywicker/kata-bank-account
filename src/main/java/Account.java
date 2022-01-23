import kata.bank.account.Amount;
import kata.bank.account.Operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int balance;
    private final List<Operation> operations;

    public Account() {
        this.balance = 0;
        this.operations = new ArrayList<>();
    }

    public void deposit(final Amount amount) {
        balance += amount.getValue();
        operations.add(new Operation());
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawal(final Amount amount) {
        balance -= amount.getValue();
        operations.add(new Operation());
    }

    public List<Operation> generateAccountStatement(final Date startDate, final Date endDate) {
        return operations;
    }
}
