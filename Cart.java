package fawry;

import java.util.*;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.quantity) {
            throw new IllegalArgumentException("can't add more than available stock for " + product.name);
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() { return items.isEmpty(); }
    public List<CartItem> getItems() { return items; }
}
