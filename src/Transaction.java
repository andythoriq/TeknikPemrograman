import java.time.LocalDateTime;
import java.util.List;

class Transaction {
    private Customer customer;
    private List<Product> products;
    private double totalHarga;
    private boolean isSent;
    private boolean isReceived;
    private boolean isPaid;
    private LocalDateTime tanggalPengiriman;
    private LocalDateTime tanggalPenerimaan;
    private LocalDateTime tanggalPembayaran;

    public Transaction(Customer customer, List<Product> products, Admin admin) {
        if (!admin.isWaktuOperasional()) {
            throw new RuntimeException("Transaksi hanya bisa dilakukan pada jam operasional.");
        }

        setCustomer(customer);
        setProducts(products);
        setTotalHarga(hitungTotalHarga());

        // cek jumlah saldo customer
        if (getCustomer().getSaldo() < getTotalHarga()) {
            throw new RuntimeException("Saldo tidak cukup untuk melakukan transaksi.");
        }

        // cek ketersediaan stok
        for (Product p : getProducts()) {
            if (p.getJmlStock() <= 0) {
                throw new RuntimeException("Stok produk habis: " + p.getNama());
            }
            p.setJmlStock(p.getJmlStock() - 1);
        }

        // pengurangan saldo customer dan penambahan saldo toko
        getCustomer().setSaldo(getCustomer().getSaldo() - getTotalHarga());
        admin.setSaldo(admin.getSaldo() + getTotalHarga());

        setPaid(true);
        setTanggalPembayaran(LocalDateTime.now());
        setSent(false);
        setReceived(false);
    }

    public double hitungTotalHarga() {
        double total = 0;
        for (Product product : getProducts()) {
            total += product.getHarga();
        }
        return total;
    }

    public void kirimBarang() {
        if (!isPaid()) {
            throw new RuntimeException("Barang tidak bisa dikirim karena belum dibayar.");
        }
        setSent(true);
        setTanggalPengiriman(LocalDateTime.now());
    }

    public void terimaBarang() {
        if (!isSent()) {
            throw new RuntimeException("Barang belum dikirim.");
        }
        setReceived(true);
        setTanggalPenerimaan(LocalDateTime.now());
    }

    public void cetakStruk() {
        System.out.println("======= Struk Pembelian =======");
        System.out.println("Customer ID: " + getCustomer().getId());
        System.out.println("Customer Nama: " + getCustomer().getNama());

        System.out.println("Produk yang Dibeli:");
        for (Product product : getProducts()) {
            System.out.println("- " + product.getNama() + " : Rp" + product.getHarga());
        }
        System.out.println("Total Harga: " + getTotalHarga());

        System.out.println("Alamat Pengiriman: " + getCustomer().getAlamat());
        System.out.println("Status Pengiriman: " + (isSent() ? "Dikirim" : "Belum Dikirim"));
        System.out.println("Status Penerimaan: " + (isReceived() ? "Diterima" : "Belum Diterima"));
        System.out.println("================================");
    }

    // getter dan setter
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public double getTotalHarga() { return totalHarga; }
    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }

    public boolean isSent() { return isSent; }
    public void setSent(boolean sent) { isSent = sent; }

    public boolean isReceived() { return isReceived; }
    public void setReceived(boolean received) { isReceived = received; }

    public boolean isPaid() { return isPaid; }
    public void setPaid(boolean paid) { isPaid = paid; }

    public LocalDateTime getTanggalPengiriman() { return tanggalPengiriman; }
    public void setTanggalPengiriman(LocalDateTime tanggalPengiriman) { this.tanggalPengiriman = tanggalPengiriman; }

    public LocalDateTime getTanggalPenerimaan() { return tanggalPenerimaan; }
    public void setTanggalPenerimaan(LocalDateTime tanggalPenerimaan) { this.tanggalPenerimaan = tanggalPenerimaan; }

    public LocalDateTime getTanggalPembayaran() { return tanggalPembayaran; }
    public void setTanggalPembayaran(LocalDateTime tanggalPembayaran) { this.tanggalPembayaran = tanggalPembayaran; }
}