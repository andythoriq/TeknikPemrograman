import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Buku Baru");
            System.out.println("2. Tambah Anggota Baru");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline
            
            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Buku berhasil ditambahkan!");
                    break;
                    
                case 2:
                    System.out.print("Masukkan nama anggota: ");
                    String memberName = scanner.nextLine();
                    library.addMember(new Member(memberName));
                    System.out.println("Anggota berhasil ditambahkan!");
                    break;
                    
                case 3:
                    System.out.print("Masukkan nama anggota: ");
                    String borrowerName = scanner.nextLine();
                    System.out.print("Masukkan judul buku: ");
                    String bookTitle = scanner.nextLine();
                    Member member = new Member(borrowerName);
                    Book book = new Book(bookTitle, "");
                    library.borrowBook(member, book);
                    System.out.println("Buku berhasil dipinjam!");
                    break;
                    
                case 4:
                    System.out.print("Masukkan nama anggota: ");
                    String returnerName = scanner.nextLine();
                    Member returner = new Member(returnerName);
                    library.returnBook(returner);
                    System.out.println("Buku berhasil dikembalikan!");
                    break;
                    
                case 5:
                    System.out.println("Terima kasih telah menggunakan Sistem Manajemen Perpustakaan!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opsi tidak valid! Silakan coba lagi.");
            }
        }
    }
}
