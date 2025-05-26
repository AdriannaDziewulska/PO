package discount;

import model.CartItem;
import model.Product;
import model.ShoppingCart;

public class BuyOneGetOneFreeDiscount implements DiscountStrategy {
    private String productName;

    public BuyOneGetOneFreeDiscount(String productName) {
        this.productName = productName;
    }

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.getName().equalsIgnoreCase(productName)) {
                int freeItems = item.getQuantity() / 2;
                return freeItems * product.getUnitPrice();
            }
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return "Drugi produkt gratis: " + productName;
    }
}
