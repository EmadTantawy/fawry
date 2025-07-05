package fawry;

import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiry) {
        super(name, price, quantity);
        this.expiryDate = expiry;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
