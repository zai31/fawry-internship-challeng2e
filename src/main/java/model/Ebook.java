package model;

import services.MailingServices;

public class Ebook extends Book implements  ForSale, Emailable{
   private String FileType;
    public Ebook(String isbn, String title, int year, double price, String author, String filetype) {
        super(isbn, title, year, price, author, BookType.EBook);
        this.FileType = filetype;
    }

    public String getFileType() {
        return FileType;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }


    @Override
    public void emailTo(String email) {
        MailingServices.send(getTitle(), email);
    }

    @Override
    public double buy(String isbn, int quantity, String email, String address) {
        if (quantity != 1) {
            throw new IllegalArgumentException("Quantum bookstore: Can only buy 1 copy of an eBook per order");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Quantum bookstore: Email required to send eBook");
        }
        emailTo(email);
        return price;

    }


}
