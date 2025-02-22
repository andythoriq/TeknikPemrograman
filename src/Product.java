class Product {
    private int id;
    private String nama;
    private int jmlStock;
    private String deskripsi;
    private double harga;

    public Product(int id, String nama, int jmlStock, String deskripsi, double harga) {
        setId(id);
        setNama(nama);
        setJmlStock(jmlStock);
        setDeskripsi(deskripsi);
        setHarga(harga);
    }

    public boolean kurangiStock(int qty) {
        if (getJmlStock() >= qty) {
            setJmlStock(
                getJmlStock() - qty
            );
            return true;
        }
        return false;
    }

    public void tambahStock(int qty) {
        setJmlStock(
            getJmlStock() + qty
        );
    }

    // Getter Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getJmlStock() { return jmlStock; }
    public void setJmlStock(int jmlStock) { this.jmlStock = jmlStock; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
}
