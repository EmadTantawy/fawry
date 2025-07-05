package fawry;

import java.util.*;

public class Checkout {
    static double SHIPPING_FEE = 30.0;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double subtotal = 0;
        double totalWeight = 0;
        List<Shippable> shippables = new ArrayList<>();
        Map<String, Integer> shipQty = new LinkedHashMap<>();

        for (CartItem ci : cart.getItems()) {
            Product p = ci.product;
            int qty = ci.quantity;
            if (qty > p.quantity) {
                System.out.println("Not enough stock for " + p.name);
                return;
            }
            if (p.isExpired()) {
                System.out.println(p.name + " is expired.");
                return;
            }
        }

        for (CartItem ci : cart.getItems()) {
            Product p = ci.product;
            int qty = ci.quantity;
            subtotal += p.price * qty;
            if (p.isShippable()) {
                shippables.add((Shippable)p);
                shipQty.put(p.name, shipQty.getOrDefault(p.name, 0) + qty);
                totalWeight += p.getWeight() * qty;
            }
        }
        double shipping = shippables.isEmpty() ? 0 : SHIPPING_FEE;
        double total = subtotal + shipping;

        if (customer.balance < total) {
            System.out.println("Customer's balance is not enough.");
            return;
        }

        if (!shippables.isEmpty()) {
            ShippingService.ship(shippables, shipQty);
        }

        System.out.println("checkout for " + customer.name);
        for (CartItem ci : cart.getItems()) {
            System.out.println(ci.quantity + "x " + ci.product.name + " " + (int)(ci.product.price * ci.quantity));
            ci.product.quantity -= ci.quantity;
        }
        System.out.println("--------------");
        System.out.println("Subtotal " + (int)subtotal);
        System.out.println("Shipping " + (int)shipping);
        System.out.println("Amount " + (int)total);

        customer.balance -= total;
    }
}
