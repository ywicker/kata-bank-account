package kata.bank.account;

import java.util.Objects;

public class Amount {
    private final int value;
    private Amount(int value) {
        this.value = value;
    }

    public static Amount createAmount(final int value) {
        assert Integer.signum(value) ==1;
        return new Amount(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
