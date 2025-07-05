package fawry;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new ShippableExpirableProduct("Cheese", 90, 5, LocalDate.now().plusDays(4), 0.25);
        Product biscuits = new ShippableExpirableProduct("Biscuits", 120, 7, LocalDate.now().plusDays(10), 0.5);
        Product tv = new ShippableProduct("TV", 2600, 2, 9.0);
        Product scratchCard = new SimpleProduct("Scratch Card", 60, 30);

        Customer c = new Customer("Ahmed", 800);

        Cart cart = new Cart();
        cart.add(cheese, 1);
        cart.add(biscuits, 2);
        cart.add(scratchCard, 3);
        Checkout.checkout(c, cart);

        Product expiredBiscuits = new ShippableExpirableProduct("Biscuits", 120, 7, LocalDate.now().minusDays(1), 0.5);
        Cart cart2 = new Cart();
        cart2.add(expiredBiscuits, 1);
        Checkout.checkout(c, cart2);
        Customer lowBalance = new Customer("Sara", 100);
        Cart cart3 = new Cart();
        cart3.add(tv, 1);
        Checkout.checkout(lowBalance, cart3);
        Cart cart4 = new Cart();
        cart4.add(tv, 5);
        Checkout.checkout(c, cart4);
        Cart emptyCart = new Cart();
        Checkout.checkout(c, emptyCart);
    }
}
