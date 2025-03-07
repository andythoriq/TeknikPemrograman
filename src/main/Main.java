package main;

import pages.TransactionPages;
import pages.WalletPages;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Money Tracker ===");
            System.out.println("1. Lihat Transaksi");
            System.out.println("2. Kelola Dompet");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Lakukan Transaksi (income/outcome) atau lihat history...");
                    TransactionPages transactionPages = new TransactionPages();
                    transactionPages.showMenu();
                    break;
                case 2:
                    System.out.println("Kelola Dompet...");
                    WalletPages walletPages = new WalletPages();
                    walletPages.showMenu();
                    break;
                case 0:
                    System.out.println("Keluar dari aplikasi...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

}
