

public class DecoratorPatternExample {


    public interface Notifier {
        void send(String message);
    }

    
    public static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending email with message: " + message);
        }
    }

 
    public static abstract class NotifierDecorator implements Notifier {
        protected Notifier decoratedNotifier;

        public NotifierDecorator(Notifier decoratedNotifier) {
            this.decoratedNotifier = decoratedNotifier;
        }

        @Override
        public void send(String message) {
            decoratedNotifier.send(message);
        }
    }

    // Concrete Decorator for SMS
    public static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS with message: " + message);
        }
    }

    // Concrete Decorator for Slack
    public static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSlack(message);
        }

        private void sendSlack(String message) {
            System.out.println("Sending Slack message with content: " + message);
        }
    }

    // Step 5: Test the Decorator Implementation
    public static void main(String[] args) {
        // Create a basic EmailNotifier
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello World");

        // Wrap EmailNotifier with SMSNotifierDecorator
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        smsNotifier.send("Hello World");

        // Wrap EmailNotifier with SlackNotifierDecorator
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);
        slackNotifier.send("Hello World");

        // Wrap EmailNotifier with both SMS and Slack decorators
        Notifier combinedNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(emailNotifier));
        combinedNotifier.send("Hello World");
    }
}
