package service;

import java.util.ArrayList;
import java.util.List;

// Generic Class
public class CartService<T> {
    private final List<T> cartItems = new ArrayList<>();

    // Generics as Parameters
    public void addToCart(T item) {
        cartItems.add(item);
        System.out.println("Ditambahkan ke keranjang: " + item);
    }

    // Wildcard
    public List<? extends T> getCartItems() {
        return cartItems;
    }
}
