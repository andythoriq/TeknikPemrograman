package models;

import interfaces.WalletCRUD;

import java.util.ArrayList;
import java.util.List;

public class Wallets implements WalletCRUD {
    private List<Wallet> walletList;

    public Wallets() {
        this.walletList = new ArrayList<>();
    }

    public Wallet findWalletByName(String name) {
        for (Wallet wallet : walletList) {
            if (wallet.getName().equalsIgnoreCase(name)) {
                return wallet;
            }
        }
        return null;
    }

    @Override
    public void add(Wallet wallet) {
        walletList.add(wallet);
        System.out.println("✅ Wallet berhasil ditambahkan: " + wallet);
    }

    @Override
    public boolean remove(Wallet wallet) {
        if (wallet != null) {
            String name = wallet.getName();
            walletList.remove(wallet);
            System.out.println("✅ Wallet '" + name + "' berhasil dihapus.");
            return true;
        }
        System.out.println("❌ Wallet tidak ditemukan.");
        return false;
    }

    @Override
    public boolean edit(Wallet wallet, double newAmount) {
        if (wallet != null) {
            wallet.setAmount(newAmount);
            System.out.println("✅ Wallet berhasil diperbarui: " + wallet);
            return true;
        }
        System.out.println("❌ Wallet tidak ditemukan.");
        return false;
    }

    @Override
    public void display() {
        if (walletList.isEmpty()) {
            System.out.println("📂 ....");
        } else {
            System.out.println("📌 Daftar Wallet:");
            for (Wallet wallet : walletList) {
                System.out.println(wallet);
            }
        }
    }

    public List<Wallet> getWalletList() {
        return walletList;
    }
}
