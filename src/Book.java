public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
        }
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}