package pages;

import interfaces.ShowMenuCRUD;
import models.*;

import java.util.List;


public class TransactionPages extends Pages implements ShowMenuCRUD {

    public TransactionPages() {
        super();
    }

    @Override
    public void showMenu() {
        Transactions transactions = new Transactions();
        Wallets wallets = new Wallets();

        while (true) {
            System.out.println("\n===== Wallet Menu =====");
            System.out.println("1. Tambah Income");
            System.out.println("2. Tambah Outcome");
            System.out.println("3. Lihat Histori Transaksi");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addIncome(transactions, wallets);
                    break;
                case 2:
                    addOutcome(transactions, wallets);
                    break;
                case 3:
                    displayHistory(transactions);
                    break;
                case 0:
                    System.out.println("🚪 Keluar dari Transaction Menu.");
                    return;
                default:
                    System.out.println("❌ Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void addIncome(Transactions transactions, Wallets wallets) {
        System.out.println("\n➕ Tambah Income");

        String date = inputString("Masukkan tanggal pemasukkan: ");

        wallets.display();
        Wallet wallet = wallets.findWalletByName(inputString("Masukkan nama Dompet: "));

        double amount = inputDouble("Masukkan jumlah pemasukkan: ");

        String category = inputString("Masukkan kategori pemasukkan: ");

        transactions.add(new Income(date, wallet, amount, category));
    }

    private void addOutcome(Transactions transactions, Wallets wallets) {
        System.out.println("\n➕ Tambah Outcome");

        String date = inputString("Masukkan tanggal pengeluaran: ");

        wallets.display();
        Wallet wallet = wallets.findWalletByName(inputString("Masukkan sumber Pengeluaran: "));

        double amount = inputDouble("Masukkan jumlah pengeluaran: ");
        String category = inputString("Masukkan kategori pengeluaran: ");

        transactions.add(new Outcome(date, wallet, amount, category));
    }

    private void displayHistory(Transactions transactions) {
        System.out.println("\n📜 Histori Transaksi");

        // Ambil daftar income dan outcome dari transactions
        List<Income> incomes = transactions.getIncomeList();
        List<Outcome> outcomes = transactions.getOutcomeList();

        // Periksa apakah ada transaksi income
        if (incomes.isEmpty() && outcomes.isEmpty()) {
            System.out.println("❌ Tidak ada transaksi yang ditemukan.");
            return;
        }

        // Tampilkan transaksi pemasukan (Income)
        if (!incomes.isEmpty()) {
            System.out.println("\n💰 Pemasukan (Income):");
            for (Income income : incomes) {
                System.out.println("- " + income.getDate() + " | Rp" + income.getAmount() + " | " + income.getCategory()
                        + " | " + income.getWallet().getName() + " | " + income.getWallet().getAmount());
            }
        }

        // Tampilkan transaksi pengeluaran (Outcome)
        if (!outcomes.isEmpty()) {
            System.out.println("\n💸 Pengeluaran (Outcome):");
            for (Outcome outcome : outcomes) {
                System.out.println("- " + outcome.getDate() + " | Rp" + outcome.getAmount() + " | " +
                        outcome.getCategory() + outcome.getWallet().getName() + " | " + outcome.getWallet().getAmount());
            }
        }
    }

}
