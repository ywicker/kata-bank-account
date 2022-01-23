package kata.bank.account;

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
}
