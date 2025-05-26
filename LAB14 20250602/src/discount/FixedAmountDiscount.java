package discount;

import model.ShoppingCart;

public class FixedAmountDiscount implements DiscountStrategy {
    private double amount;

    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        return amount;
    }

    @Override
    public String getDescription() {
        return "Stała zniżka: " + amount + " zł";
    }
}
