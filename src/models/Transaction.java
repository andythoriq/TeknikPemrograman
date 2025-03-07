package models;

public abstract class Transaction {
    protected String id;
    protected String date;
    protected Wallet wallet;
    protected double amount;
    protected String category;

    public Transaction(String date, Wallet wallet, double amount, String category) {
        this.id = getId();
        this.date = date;
        this.wallet = wallet;
        this.amount = amount;
        this.category = category;
    }

    protected abstract void updateSaldo(Wallet wallet, double newAmount);

    protected abstract String getId();

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Wallet getWallet() {
        return this.wallet;
    }
}
