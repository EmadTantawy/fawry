package fawry;

import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> toShip, Map<String, Integer> quantities) {
        System.out.println("the shipment contains:");
        double totalWeight = 0.0;
        Set<String> done = new HashSet<>();
        for (Shippable item : toShip) {
            String pname = item.getName();
            if (!done.contains(pname)) {
                int qty = quantities.getOrDefault(pname, 0);
                int grams = (int) Math.round(item.getWeight() * 1000);
                System.out.println(qty + "* " + pname + " " + grams + "g");
                totalWeight += item.getWeight() * qty;
                done.add(pname);
            }
        }
        System.out.printf("total package weight %.1fkg\n", totalWeight);
    }
}
