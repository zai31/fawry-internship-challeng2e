package model;

public class DemoBook extends Book {
    public DemoBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author,BookType.DemoBook);
    }

}
