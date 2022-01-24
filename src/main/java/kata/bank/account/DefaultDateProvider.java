package kata.bank.account;

import java.util.Date;

public class DefaultDateProvider implements DateProvider {
    @Override
    public Date getDate() {
        return new Date();
    }
}
