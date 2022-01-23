public class Account {
    int balance;
    public Account() {
        this.balance = 0;
    }

    public void deposit(int i) {
        balance += i;
    }

    public int getBalance() {
        return balance;
    }
}
