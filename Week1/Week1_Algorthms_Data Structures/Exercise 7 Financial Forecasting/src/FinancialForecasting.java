public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: Calculate the future value
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }

    // Main method to test the recursive calculation
    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial investment amount
        double growthRate = 0.05; // Growth rate (5%)
        int years = 10; // Number of years for forecasting

        // Calculate the future value using recursion
        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        
        // Print the result
        System.out.printf("The future value after %d years is: $%.2f%n", years, futureValue);
    }
}
