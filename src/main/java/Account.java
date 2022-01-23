public class Account {
    int balance;
    public Account() {
        this.balance = 0;
    }

    public void deposit(int i) {
        assert i!=0;
        balance += i;
    }

    public int getBalance() {
        return balance;
    }
}
