import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product(id=" + productId + ", name=" + productName + ", category=" + category + ")";
    }
}

public class ECommerceSearch {

    public static void main(String[] args) {
        
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Home Appliances"),
            new Product(4, "Desk Chair", "Furniture"),
            new Product(5, "Smartwatch", "Electronics")
        };

        // Sorting products by productId for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.productId, p2.productId));

        // Search for a product using linear search
        int targetIdLinear = 3;
        Product resultLinear = linearSearch(products, targetIdLinear);
        System.out.println("Linear Search Result: " + resultLinear);

        // Search for a product using binary search
        int targetIdBinary = 3;
        Product resultBinary = binarySearch(products, targetIdBinary);
        System.out.println("Binary Search Result: " + resultBinary);
    }

    // Linear Search Implementation
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search Implementation
    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
