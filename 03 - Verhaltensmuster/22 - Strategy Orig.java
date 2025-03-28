class ShippingCalculator {
    public double calculateCost(double weight, String method) {
        if (method.equals("standard")) {
            // Standard shipping: $2 per kg
            return weight * 2.0;
        } else if (method.equals("express")) {
            // Express shipping: $5 per kg + $10 handling
            return (weight * 5.0) + 10.0;
        } else if (method.equals("international")) {
            // International shipping: $8 per kg + $20 handling
            return (weight * 8.0) + 20.0;
        }
        throw new IllegalArgumentException("Unknown shipping method");
    }
}

class Main {
    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator();
        double weight = 5.0; // 5 kg package
        
        // Calculate shipping costs
        double standardCost = 
            calculator.calculateCost(weight, "standard");
        System.out.println("Standard shipping cost: $" 
            + standardCost);
        
        double expressCost = 
            calculator.calculateCost(weight, "express");
        System.out.println("Express shipping cost: $" 
            + expressCost);
        
        double internationalCost = 
            calculator.calculateCost(weight, "international");
        System.out.println("International shipping cost: $" 
            + internationalCost);
    }
}