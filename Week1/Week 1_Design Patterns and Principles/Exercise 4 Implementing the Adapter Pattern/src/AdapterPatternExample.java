// AdapterPatternExample.java

public class AdapterPatternExample {

    // Step 2: Define the Target Interface
    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Step 3: Implement Adaptee Classes

    // Adaptee Class 1: PayPalGateway
    public static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }

    // Adaptee Class 2: StripeGateway
    public static class StripeGateway {
        public void charge(double amount) {
            System.out.println("Charging $" + amount + " through Stripe.");
        }
    }

    // Step 4: Implement the Adapter Class

    // Adapter for PayPalGateway
    public static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPalGateway;

        public PayPalAdapter(PayPalGateway payPalGateway) {
            this.payPalGateway = payPalGateway;
        }

        @Override
        public void processPayment(double amount) {
            payPalGateway.makePayment(amount);
        }
    }

    // Adapter for StripeGateway
    public static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripeGateway;

        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        @Override
        public void processPayment(double amount) {
            stripeGateway.charge(amount);
        }
    }

    // Step 5: Test the Adapter Implementation
    public static void main(String[] args) {
        // Create instances of the gateways
        PayPalGateway payPal = new PayPalGateway();
        StripeGateway stripe = new StripeGateway();

        // Create adapters for the gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);

        // Process payments using adapters
        payPalAdapter.processPayment(150.75);
        stripeAdapter.processPayment(200.50);
    }
}
