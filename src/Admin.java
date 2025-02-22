import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Admin {
    private String nama;
    private double saldo;
    private String jamBuka;
    private String jamTutup;
    private List<Product> products;

    public Admin(String nama, double saldo, String jamBuka, String jamTutup, List<Product> products) {
        setNama(nama);
        setSaldo(saldo);
        setJamBuka(jamBuka);
        setJamTutup(jamTutup);
        setProducts(products);
    }

    public boolean isWaktuOperasional() {
        int sekarang = LocalDateTime.now().getHour();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        int jamBukaInHour = LocalTime.parse(getJamBuka(), formatter).getHour();
        int jamTutupInHour = LocalTime.parse(getJamTutup(), formatter).getHour();

        return sekarang >= jamBukaInHour && sekarang < jamTutupInHour;
    }

    public void tambahProduk(Product product) {
        getProducts().add(product);
    }

    public void hapusProduk(int productId) {
        getProducts().removeIf(p -> p.getId() == productId);
    }

    public void updateHargaProduk(int productId, double newHarga) {
        for (Product p : getProducts()) {
            if (p.getId() == productId) {
                p.setHarga(newHarga);
                break;
            }
        }
    }

    public void tambahSaldo(double jumlah) {
        setSaldo(getSaldo() + jumlah);
    }

    // Getters dan Setters
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public String getJamBuka() { return jamBuka; }
    public void setJamBuka(String jamBuka) { this.jamBuka = jamBuka; }

    public String getJamTutup() { return jamTutup; }
    public void setJamTutup(String jamTutup) { this.jamTutup = jamTutup; }
}