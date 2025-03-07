package interfaces;

import models.Wallet;

public interface WalletCRUD {
    void display();
    boolean edit(Wallet wallet, double newData);
    boolean remove(Wallet wallet);
    void add(Wallet wallet);
}
