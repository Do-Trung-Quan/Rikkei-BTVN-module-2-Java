package ex02;

import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class ex02 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Java", "James", 100.0));
        books.add(new Book("Python", "Guido", 120.0));
        books.add(new Book("C++", "Bjarne", 150.0));

        System.out.println("----- LIST OF BOOKS -----");
        for (int i = 0; i < books.size(); i++) {
            books.get(i).printInfo();
            if (i < books.size() - 1) {
                System.out.println();
            }
        }
    }
}
