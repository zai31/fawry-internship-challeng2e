package model;

public abstract class Product {
    protected String id;
    protected String title;
    protected double price;

    public Product(String id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
