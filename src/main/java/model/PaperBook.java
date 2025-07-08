package model;

import services.ShippingService;

public class PaperBook extends Book implements Shippable,ForSale{
    int stock ;
    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author, BookType.PaperBook);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public void ship(String address) {
        ShippingService.send(title, address);
    }

    @Override
    public double buy(String isbn, int quantity, String email, String address) {
        reduceQuantity(quantity);
        if (address != null && !address.isBlank()) {
            ship(address);
        } else {System.out.println("Quantum bookstore: No shipping address provided. Book will not be shipped.");}

        double amount = quantity * price;
System.out.println("Quantum bookstore: Amount paid = " + amount);
    return amount;
    }

    private void reduceQuantity(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Out of stock");
        }
        stock -= quantity;
    }
}

