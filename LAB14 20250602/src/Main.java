import discount.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Łukasz Kucharczyk", true);
        ShoppingCart cart = new ShoppingCart(customer);

        Product laptop = new Product("Laptop", 5000.0);
        Product mouse = new Product("Myszka", 100.0);

        cart.addItem(laptop, 1);
        cart.addItem(mouse, 2);

        cart.addDiscountStrategy(new PercentageDiscount(10));
        cart.addDiscountStrategy(new FixedAmountDiscount(50));
        cart.addDiscountStrategy(new LoyaltyDiscount());
        cart.addDiscountStrategy(new BuyOneGetOneFreeDiscount("Myszka"));

        System.out.println("Cena przed rabatami: " + cart.calculateTotalPrice());
        System.out.println("Łączny rabat: " + cart.calculateTotalDiscount());
        System.out.println("Do zapłaty: " + cart.calculateFinalPrice());
        System.out.println("Zastosowane rabaty:");
        for (String desc : cart.getAppliedDiscountDescriptions()) {
            System.out.println("- " + desc);
        }
    }
}
