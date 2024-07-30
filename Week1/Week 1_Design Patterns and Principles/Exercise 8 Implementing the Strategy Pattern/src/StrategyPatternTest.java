// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy 1: Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder Name: " + cardHolderName);
    }
}

// Concrete Strategy 2: PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
        System.out.println("PayPal Email: " + email);
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Test Class
public class StrategyPatternTest {
    public static void main(String[] args) {
        // Create context
        PaymentContext paymentContext = new PaymentContext();

        // Create and set Credit Card payment strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment("7008180769-456-8965", "Sudhansu Rout");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(150.00);

        // Create and set PayPal payment strategy
        PaymentStrategy payPalPayment = new PayPalPayment("sudhansurout03@gmail.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(200.00);
    }
}

