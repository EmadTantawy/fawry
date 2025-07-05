package fawry;

public abstract class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isExpired() {return false;}
    public boolean isShippable() {return false;}
    public double getWeight() {return 0.0;}
}
