package discount;

import model.Customer;
import model.ShoppingCart;

public class LoyaltyDiscount implements DiscountStrategy {
    private double percentage = 5.0;

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        Customer customer = cart.getCustomer();
        if (customer != null && customer.isLoyalCustomer()) {
            return cart.calculateTotalPrice() * (percentage / 100.0);
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return "Rabat lojalnościowy: " + percentage + "%";
    }
}
