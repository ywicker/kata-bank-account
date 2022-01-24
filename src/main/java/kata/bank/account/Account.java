package kata.bank.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static kata.bank.account.OperationType.DEPOSIT;
import static kata.bank.account.OperationType.WITHDRAWAL;

public class Account {
    private final List<Operation> operations;
    private final DateProvider dateProvider;

    public Account(final DateProvider dateProvider) {
        this.operations = new ArrayList<>();
        this.dateProvider = dateProvider;
    }

    public void deposit(final Amount amount) {
        operations.add(new Operation(
                dateProvider.getDate(),
                amount,
                DEPOSIT));
    }

    public int getBalance() {
        return operations.stream()
                .map(operation -> operation.getType().amountToApply(operation.getAmount()))
                .reduce(0, Integer::sum);
    }

    public void withdrawal(final Amount amount) {
        operations.add(new Operation(
                dateProvider.getDate(),
                amount,
                WITHDRAWAL));
    }

    public List<Operation> generateAccountStatement(final Date startDate, final Date endDate) {
        return operations;
    }
}
