package kata.bank.account;

public enum OperationType {
    WITHDRAWAL {
        public int amountToApply(Amount amount) {
            return -amount.getValue();
        }
    },
    DEPOSIT {
        public int amountToApply(Amount amount) {
            return amount.getValue();
        }
    };

    public int amountToApply(Amount amount) {
        return amount.getValue();
    }
}
