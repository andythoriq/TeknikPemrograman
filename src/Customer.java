class Customer {
    private int id;
    private String nama;
    private String alamat;
    private String username;
    private String password;
    private double saldo;

    public Customer(int id, String nama, String alamat, String username, String password, double saldo) {
        setId(id);
        setNama(nama);
        setAlamat(alamat);
        setUsername(username);
        setPassword(password);
        setSaldo(saldo);
    }

    public boolean kurangiSaldo(double jumlah) {
        if (getSaldo() >= jumlah) {
            setSaldo(getSaldo() - jumlah);
            return true;
        }
        return false;
    }

    public void tambahSaldo(double jumlah) {
        setSaldo(getSaldo() + jumlah);
    }

    // Getters dan Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
}