import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create beberapa produk menggunakan constructor
        Product p1 = new Product(1, "Laptop", 5, "Laptop gaming", 9000000);
        Product p2 = new Product(2, "Mouse", 10, "Mouse wireless", 300000);

        // gabungkon object produk ke dalam array
        List<Product> daftarProduk = Arrays.asList(p1, p2);

        // create customer menggunakan constructor
        Customer customer = new Customer(1, "Thoriq", "Jl. Merdeka", "robertm", "pass123", 20000000);

        // create admin menggunakan constructor
        Admin admin = new Admin("Admin Toko", 0, "08:00", "22:00", daftarProduk);

        try {
            Transaction transaksi = new Transaction(customer, daftarProduk, admin);
            transaksi.kirimBarang();
            transaksi.terimaBarang();
            transaksi.cetakStruk();
        } catch (RuntimeException e) {
            System.out.println("Transaksi gagal: " + e.getMessage());
        }
    }
}
