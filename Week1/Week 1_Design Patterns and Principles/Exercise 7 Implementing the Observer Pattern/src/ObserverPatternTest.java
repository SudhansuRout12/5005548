import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName) {
        this.stockName = stockName;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

// Observer interface
interface Observer {
    void update(String stockName, double price);
}

// Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App: Stock " + stockName + " price updated to " + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Web App: Stock " + stockName + " price updated to " + price);
    }
}

// Test class
public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create stock market instance
        StockMarket stockMarket = new StockMarket("AAPL");

        // Create observers
        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price and notify observers
        stockMarket.setPrice(150.00);
        stockMarket.setPrice(155.50);

        // Deregister an observer
        stockMarket.deregisterObserver(webApp);

        // Change stock price and notify remaining observers
        stockMarket.setPrice(160.00);
    }
}
