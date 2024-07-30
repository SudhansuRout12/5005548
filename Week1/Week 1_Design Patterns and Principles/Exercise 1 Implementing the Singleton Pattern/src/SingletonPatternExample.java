// SingletonPatternExample.java

public class SingletonPatternExample {

    // Logger class implementing Singleton Pattern
    public static class Logger {

        // Step 1: Create a private static instance of Logger
        private static Logger instance;

        // Step 2: Make the constructor private
        private Logger() {
            // Private constructor to prevent instantiation
        }

        // Step 3: Provide a public static method to get the instance
        public static synchronized Logger getInstance() {
            // Create a new instance if none exists
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Method to log messages
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    // Main method to test the Singleton pattern
    public static void main(String[] args) {
        // Create two references to the Logger instance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Test if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Logger instances are the same.");
        } else {
            System.out.println("Logger instances are different.");
        }

        // Log a message using both references
        logger1.log("This is a log message from logger1.");
        logger2.log("This is a log message from logger2.");

        // Verify that the log messages are printed from the same instance
    }
}
