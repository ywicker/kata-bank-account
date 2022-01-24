package kata.bank.account;

import java.util.Date;
import java.util.Objects;

public class Operation {
    private final Date operationDate;
    private final Amount amount;
    private final OperationType type;

    public Operation(final Date operationDate, final Amount amount, final OperationType type) {
        this.operationDate = operationDate;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(operationDate, operation.operationDate) && Objects.equals(amount, operation.amount) && type == operation.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationDate, amount, type);
    }

    public OperationType getType() {
        return this.type;
    }

    public Amount getAmount() {
        return this.amount;
    }
}
