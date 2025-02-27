import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionId;
    private Customer customer;
    private Tickets tickets;
    private double totalPrice;
    private String paymentMethod;
    private String transactionDate;
    private String transactionTime;
    private String status;
    private String receiptCode;

    // Constructor
    public Transaction(String transactionId, Customer customer, Tickets tickets, String paymentMethod, String status) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.tickets = tickets;
        this.paymentMethod = paymentMethod;
        this.status = status;

        // Menghitung total harga tiket
        this.totalPrice = calculateTotalPrice();

        // Mengatur tanggal & waktu transaksi otomatis
        this.transactionDate = LocalDate.now().toString();
        this.transactionTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

        // Membuat kode struk unik
        this.receiptCode = generateReceiptCode();
    }

    // Menghitung total harga tiket
    private double calculateTotalPrice() {
        double total = 0;
        for (Ticket ticket : tickets.getTickets()) {
            total += ticket.getPrice();
        }
        return total;
    }

    // Membuat kode struk unik dari ID transaksi + tanggal
    private String generateReceiptCode() {
        return "RC-" + transactionId + "-" + transactionDate.replace("-", "");
    }

    // Menampilkan detail transaksi
    public void displayTransaction() {
        System.out.println("=== TRANSAKSI TIKET BIOSKOP ===");
        System.out.println("ID Transaksi  : " + transactionId);
        System.out.println("Nama Customer : " + customer.getName());
        System.out.println("Metode Bayar  : " + paymentMethod);
        System.out.println("Tanggal       : " + transactionDate);
        System.out.println("Waktu         : " + transactionTime);
        System.out.println("Total Harga   : Rp" + totalPrice);
        System.out.println("Status        : " + status);
        System.out.println("Kode Struk    : " + receiptCode);
        System.out.println("Tiket yang Dibeli:");
        tickets.displayTickets();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
