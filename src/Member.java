public class Member {
    private String name;
    private Book borrowedBook;

    public Member(String name) {
        this.name = name;
        this.borrowedBook = null;
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            this.borrowedBook = book;
            book.borrowBook();
        }
    }

    public void returnBook() {
        if (borrowedBook != null) {
            borrowedBook.returnBook();
            borrowedBook = null;
        }
    }
}