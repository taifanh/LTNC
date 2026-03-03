package Prob2_5;
public class Book {
    private String title, author;
    private double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public boolean equals(Book other) {
        return this.title == other.title && this.author == other.author && this.price == other.price;
    }

    public static void main(String[] args) {
        Book book1 = new Book("a", "b", 0);
        Book book2 = new Book("a", "b", 0);
        System.out.println(book1 == book2);
        System.out.println(book1.equals(book2));
    }
}
