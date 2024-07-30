// ProxyPatternExample.java

public class ProxyPatternExample {

    // Step 2: Define the Subject Interface
    public interface Image {
        void display();
    }

    // Step 3: Implement Real Subject Class
    public static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading image: " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Step 4: Implement Proxy Class
    public static class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;
        private boolean isCached;

        public ProxyImage(String filename) {
            this.filename = filename;
            this.isCached = false;
        }

        @Override
        public void display() {
            if (!isCached) {
                realImage = new RealImage(filename);
                isCached = true;
            }
            realImage.display();
        }
    }

    // Step 5: Test the Proxy Implementation
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image is loaded and displayed
        image1.display();
        // Image is already cached, so no loading
        image1.display();

        // Image is loaded and displayed
        image2.display();
        // Image is already cached, so no loading
        image2.display();
    }
}
