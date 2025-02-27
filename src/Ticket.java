import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private Movie movie;
    private char row;
    private char seat;
    private char theater;
    private double price;
    private String date; // Format: YYYY-MM-DD
    private String time; // Format: HH:mm:ss
    private String ticket_code; // Unik berdasarkan date, time, row, seat, theater

    public Ticket(Movie movie, char row, char seat, char theater, double price, String date, String time) {
        this.movie = movie;
        this.row = row;
        this.seat = seat;
        this.theater = theater;
        this.price = price;

        // Mengambil tanggal hari ini
        this.date = date; // Format: YYYY-MM-DD

        // Mengambil waktu saat ini
        this.time = time;

        // Membuat kode tiket unik
        this.ticket_code = date.replace("-", "") + time.replace(":", "") + row + seat + theater;
    }

    public Ticket(Movie movie, char row, char seat, char theater, double price) {
        this(movie, row, seat, theater, price, LocalDate.now().toString(), LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))); // Memanggil constructor utama
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printTicket() {
        System.out.println("==== TICKET ====");
        System.out.println("Movie   : " + movie.getTitle() + " (" + movie.getGenre() + ")");
        System.out.println("Seat    : " + row + seat);
        System.out.println("Theater : " + theater);
        System.out.println("Price   : Rp" + price);
        System.out.println("Date    : " + date);
        System.out.println("Time    : " + time);
        System.out.println("Code    : " + ticket_code);
        System.out.println("================");
    }
}
