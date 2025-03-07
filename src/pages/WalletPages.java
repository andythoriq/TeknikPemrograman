package pages;

import interfaces.ShowMenuCRUD;
import models.Wallet;
import models.Wallets;

public class WalletPages extends Pages implements ShowMenuCRUD {

    public WalletPages() {
        super();
    }

    @Override
    public void showMenu() {
        Wallets wallets = new Wallets();

        while (true) {
            System.out.println("\n===== Wallet Menu =====");
            System.out.println("1. Tambah Wallet");
            System.out.println("2. Hapus Wallet");
            System.out.println("3. Edit Wallet");
            System.out.println("4. Tampilkan Semua Wallet");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addWallet(wallets);
                    break;
                case 2:
                    removeWallet(wallets);
                    break;
                case 3:
                    editWallet(wallets);
                    break;
                case 4:
                    wallets.display();
                    break;
                case 0:
                    System.out.println("🚪 Keluar dari Wallet Menu.");
                    return;
                default:
                    System.out.println("❌ Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void addWallet(Wallets wallets) {
        System.out.println("\n➕ Tambah Wallet");
        String name = inputString("Masukkan nama wallet: ");
        double amount = inputDouble("Masukkan jumlah saldo awal: ");

        wallets.add(new Wallet(name, amount));
    }

    private void removeWallet(Wallets wallets) {
        System.out.println("\n🗑 Hapus Wallet");
        String name = inputString("Masukkan nama wallet yang akan dihapus: ");

        Wallet wallet = wallets.findWalletByName(name);
        wallets.remove(wallet);
    }

    private void editWallet(Wallets wallets) {
        System.out.println("\n✏ Edit Wallet");
        String name = inputString("Masukkan nama wallet yang ingin diedit: ");

        double newAmount = inputDouble("Masukkan saldo baru: ");

        Wallet wallet = wallets.findWalletByName(name);
        wallets.edit(wallet, newAmount);
    }
}
