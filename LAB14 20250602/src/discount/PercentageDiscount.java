package discount;

import model.ShoppingCart;

public class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        return cart.calculateTotalPrice() * (percentage / 100.0);
    }

    @Override
    public String getDescription() {
        return "Rabat procentowy: " + percentage + "%";
    }
}
