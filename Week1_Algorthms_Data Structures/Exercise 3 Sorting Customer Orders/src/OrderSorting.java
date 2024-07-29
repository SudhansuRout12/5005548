import java.util.Arrays;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order(id=" + orderId + ", customerName=" + customerName + ", totalPrice=" + totalPrice + ")";
    }
}

public class OrderSorting {

    public static void main(String[] args) {
        // Creating an array of orders
        Order[] orders = {
            new Order(1, "Alice", 250.75),
            new Order(2, "Bob", 150.50),
            new Order(3, "Charlie", 350.00),
            new Order(4, "Diana", 200.00),
            new Order(5, "Eve", 275.00)
        };

        // Display unsorted orders
        System.out.println("Unsorted Orders:");
        printOrders(orders);

        // Sorting using Bubble Sort
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleSortedOrders);
        System.out.println("\nOrders Sorted by Bubble Sort:");
        printOrders(bubbleSortedOrders);

        // Sorting using Quick Sort
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        printOrders(quickSortedOrders);
    }

    // Bubble Sort Implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap orders[j] and orders[j+1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort Implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    // Partition method for Quick Sort
    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // Method to print orders
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
