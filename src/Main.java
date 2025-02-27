import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Buat daftar movie dalam ArrayList
        ArrayList<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("Inception", "Sci-Fi", 148));
        movieList.add(new Movie("The Dark Knight", "Action", 152));
        movieList.add(new Movie("Interstellar", "Sci-Fi", 169));

        // Buat instance Movies dengan parameter ArrayList movieList
        Movies movies = new Movies(movieList);

        // Tampilkan daftar film
        System.out.println("Daftar Film yang Tersedia:");
        movies.displayMovies();

        // Ticket
        Tickets tickets = new Tickets();

        tickets.addTicket(new Ticket(movieList.get(0), '1', 'A', '2', 50_000));
        tickets.addTicket(new Ticket(movieList.get(0), '1', 'B', '2', 50_000));
        tickets.addTicket(new Ticket(movieList.get(0), '1', 'C', '2', 50_000));
        tickets.addTicket(new Ticket(movieList.get(0), '1', 'D', '2', 50_000));

        // Customer
        Customer customer = new Customer("Trq", "trq@email.com", "0808-6969-8888");

        // Transaction
        Transaction transaction = new Transaction("TX12345", customer, tickets, "E-Wallet", "Success");

        // Tampilkan detail transaksi
        transaction.displayTransaction();
    }
}
