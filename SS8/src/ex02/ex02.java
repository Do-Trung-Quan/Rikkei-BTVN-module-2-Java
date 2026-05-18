package ex02;

    class Book {
        String title;
        String author;
        double price;

        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
        }
    }
    public class ex02{
        public static void main(String[] args) {
            Book book = new Book("Effective Java", "Joshua Bloch", 45.0);
            book.printInfo();
        }
    }

