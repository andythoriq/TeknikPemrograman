package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Income extends Transaction {
    public Income(String date, Wallet wallet, double amount, String category) {
        super(date, wallet, amount, category);
        this.id = getId();
    }

    @Override
    protected void updateSaldo(Wallet wallet, double newAmount) {
        wallet.setAmount(wallet.getAmount() + newAmount);
    }

    @Override
    protected String getId() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = now.format(formatter);

        return "Income-" + timestamp;
    }
}

