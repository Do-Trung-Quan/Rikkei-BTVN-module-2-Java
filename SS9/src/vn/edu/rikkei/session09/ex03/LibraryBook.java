package vn.edu.rikkei.session09.ex03;

public class LibraryBook {
    private static int totalBorrowed = 0;
    private String bookId;
    private String title;
    private String author;
    private boolean isBorrowed;

    public LibraryBook(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            totalBorrowed++;
            return true;
        } else {
            String warning = String.format("[Mượn %s] Cảnh báo: Sách đã được mượn!", bookId);
            System.out.printf("| %-53s |\n", warning);
            return false;
        }
    }

    public boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            totalBorrowed--;
            return true;
        } else {
            String warning = String.format("[Trả  %s] Cảnh báo: Sách hiện đang ở thư viện!", bookId);
            System.out.printf("| %-53s |\n", warning);
            return false;
        }
    }

    public static int getTotalBorrowed() {
        return totalBorrowed;
    }
}