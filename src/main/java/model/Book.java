package model;

public class Book extends Product {
    protected int year;
    protected String author;
    private BookType bookType;

    public Book(String isbn, String title, int year, double price, String author, BookType bookType) {
        super(isbn, title, price);
        this.year = year;
        this.author = author;
        this.bookType = bookType;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;}


    public boolean isOutdated(int yearsThreshold) {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year > yearsThreshold;
    }
}
