import kata.bank.account.Amount;

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
}
