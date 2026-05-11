package solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class OCPFollowed {
    static void main(String[] args) {
        Product product1 = new Product("Pizza", 500.00);
        Product product2 = new Product("Burger", 300.00);

        DiscountEngine discountEngine = new DiscountEngine();
        discountEngine.calculateDiscountAmount(product1);
        discountEngine.calculateDiscountAmount(product2);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(product1);
        cart.addItem(product2);

        InventoryAdjustment inventoryAdjustment = new InventoryAdjustment();
        inventoryAdjustment.updateAvailableQty(product1);
        inventoryAdjustment.updateAvailableQty(product2);

        CartPricingService pricingService = new CartPricingService();
        double totalPrice = pricingService.calculateTotal(cart.getItems());
        System.out.println("Total price is " + totalPrice);

        new SaveToSqlDatabase().processData(cart.getItems());
        new SaveToMQLDatabase().processData(cart.getItems());
        new SaveToFlatFile().processData(cart.getItems());

    }
}

class Product {
    private final String name;
    private final double price;
    private double discountAmount;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
}

class ShoppingCart {

    private final List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        items.add(item);
        System.out.printf("Added product %s to shopping cart.\n", item.getName());
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }


}

class CartPricingService {

    public double calculateTotal(List<Product> items) {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice() - item.getDiscountAmount();
        }
        return total;
    }
}

class DiscountEngine {

    public double calculateDiscountAmount(Product product) {
        double discount = product.getPrice() * 0.1;
        product.setDiscountAmount(product.getPrice() - discount);
        System.out.println("Discount for " + product.getName() + " is " + discount);
        return discount;
    }
}


class InventoryAdjustment {
    public void updateAvailableQty(Product product) {
        System.out.println("Update Available Qty for " + product.getName());
    }

    public void updateReservedQty(OcpProduct product) {
        System.out.println("Update Reserved Qty for " + product.getName());
    }
}


interface DBManager {
   public void processData(List<Product> products);
}

class SaveToSqlDatabase implements DBManager {
    @Override
    public void processData(List<Product> products) {
        for (Product product : products) {
            System.out.println("Saving SQL Data... " + product.getName());
        }
    }
}

class SaveToMQLDatabase implements DBManager {
    @Override
    public void processData(List<Product> products) {
        for (Product product : products) {
            System.out.println("Saving SQL Data... " + product.getName());
        }
    }
}

class SaveToFlatFile implements DBManager {
    @Override
    public void processData(List<Product> products) {
        for (Product product : products) {
            System.out.println("Saving SQL Data... " + product.getName());
        }
    }
}


