
import java.util.HashMap;
import java.util.Map;

// Define the Product class
class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

// Define the InventoryManager class
class InventoryManager {
    private Map<String, Product> inventory;

    // Constructor
    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // Add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    // Update a product
    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
            System.out.println("Product updated: " + updatedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Product removedProduct = inventory.remove(productId);
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Get a product
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }
}

// Main class to run the program
public class InventoryManagementSystem {
    public static void main(String[] args) {
        // Create an InventoryManager instance
        InventoryManager manager = new InventoryManager();

        // Create some Product instances
        Product product1 = new Product("001", "Laptop", 10, 999.99);
        Product product2 = new Product("002", "Smartphone", 20, 499.99);
        
        // Add products to the inventory
        manager.addProduct(product1);
        manager.addProduct(product2);
        
        // Display a product
        System.out.println("Getting product with ID 001: " + manager.getProduct("001"));
        
        // Update a product
        Product updatedProduct1 = new Product("001", "Laptop", 8, 949.99);
        manager.updateProduct("001", updatedProduct1);
        
        // Delete a product
        manager.deleteProduct("002");
        
        // Try to get a deleted product
        System.out.println("Getting product with ID 002: " + manager.getProduct("002"));
    }
}
