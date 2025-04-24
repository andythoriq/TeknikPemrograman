import model.Product;
import model.Customer;
import service.CartService;
import service.ProductRepository;
import service.Utils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRepository<Product> productRepo = new ProductRepository<>();
        CartService<Product> cart = new CartService<>();
        
        productRepo.save( new Product<String>("P001", "Laptop"));
        productRepo.save(new Product<Integer>(2, "Smartphone"));
        productRepo.save(new Product<>("P003", "Tablet"));
        productRepo.save(new Product<>(4, "Smartwatch"));

        System.out.print("Masukkan nama customer: ");
        String nama = scanner.nextLine();
        Customer customer = new Customer(nama);
        
        while (true) {
            System.out.println("\n== MENU ==");
            System.out.println("1. Lihat Produk");
            System.out.println("2. Tambah ke Keranjang");
            System.out.println("3. Lihat Keranjang");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            
            int pilih = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilih) {
                case 1:
                    productRepo.findAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("=== Menambah ke Keranjang === \n");
                    System.out.print("Masukkan kode produk: ");
                    String kode = scanner.nextLine();
                    Product p = productRepo.findByCode(kode);
                    if (p != null) {
                        cart.addToCart(p);
                    } else {
                        System.out.println("Produk tidak ditemukan!");
                    }
                    break;
                case 3:
                    Utils.printAll(cart.getCartItems());
                    break;
                case 0:
                    System.out.println("Terima kasih, " + customer.getName() + "!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }
}
