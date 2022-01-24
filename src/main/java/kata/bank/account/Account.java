package kata.bank.account;

import kata.bank.account.Amount;
import kata.bank.account.Operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static kata.bank.account.OperationType.DEPOSIT;
import static kata.bank.account.OperationType.WITHDRAWAL;

public class Account {
    private int balance;
    private final List<Operation> operations;
    private final DateProvider dateProvider;

    public Account(final DateProvider dateProvider) {
        this.balance = 0;
        this.operations = new ArrayList<>();
        this.dateProvider = dateProvider;
    }

    public void deposit(final Amount amount) {
        balance += amount.getValue();
        operations.add(new Operation(
                dateProvider.getDate(),
                amount,
                DEPOSIT));
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawal(final Amount amount) {
        balance -= amount.getValue();
        operations.add(new Operation(
                dateProvider.getDate(),
                amount,
                WITHDRAWAL));
    }

    public List<Operation> generateAccountStatement(final Date startDate, final Date endDate) {
        return operations;
    }
}
