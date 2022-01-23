public class Account {
    int balance;
    public Account() {
        this.balance = 0;
    }

    public void deposit(int amount) {
        assert Integer.signum(amount) ==1;
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
