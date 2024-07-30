// BuilderPatternExample.java

public class BuilderPatternExample {

    // Step 2: Define the Product Class
    public static class Computer {
        // Attributes of the Computer class
        private final String CPU;
        private final int RAM;
        private final int Storage;
        private final boolean isGraphicsCard;
        private final boolean isBluetooth;

        // Private constructor to be used by the Builder class
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.isGraphicsCard = builder.isGraphicsCard;
            this.isBluetooth = builder.isBluetooth;
        }

        // Getters for the attributes
        public String getCPU() { return CPU; }
        public int getRAM() { return RAM; }
        public int getStorage() { return Storage; }
        public boolean hasGraphicsCard() { return isGraphicsCard; }
        public boolean hasBluetooth() { return isBluetooth; }

        // To print the details of the Computer
        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + Storage + "GB, Graphics Card=" + (isGraphicsCard ? "Yes" : "No") + ", Bluetooth=" + (isBluetooth ? "Yes" : "No") + "]";
        }

        // Step 3: Implement the Builder Class
        public static class Builder {
            // Mandatory attributes
            private final String CPU;
            private final int RAM;
            private final int Storage;

            // Optional attributes
            private boolean isGraphicsCard;
            private boolean isBluetooth;

            // Builder constructor with mandatory attributes
            public Builder(String CPU, int RAM, int Storage) {
                this.CPU = CPU;
                this.RAM = RAM;
                this.Storage = Storage;
            }

            // Setter methods for optional attributes
            public Builder setGraphicsCard(boolean isGraphicsCard) {
                this.isGraphicsCard = isGraphicsCard;
                return this;
            }

            public Builder setBluetooth(boolean isBluetooth) {
                this.isBluetooth = isBluetooth;
                return this;
            }

            // Method to build the Computer instance
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Step 5: Test the Builder Implementation
    public static void main(String[] args) {
        // Create a basic Computer configuration
        Computer basicComputer = new Computer.Builder("Intel i5", 8, 256)
                .build();
        System.out.println(basicComputer);

        // Create a high-end Computer configuration with optional features
        Computer gamingComputer = new Computer.Builder("Intel i9", 16, 1024)
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();
        System.out.println(gamingComputer);
    }
}
