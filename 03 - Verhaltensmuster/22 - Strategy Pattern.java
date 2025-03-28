// Strategy interface
interface ShippingStrategy {
    double calculateCost(double weight);
}

// Concrete strategies
class StandardShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        // Standard shipping: $2 per kg
        return weight * 2.0;
    }
}

class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        // Express shipping: $5 per kg + $10 handling
        return (weight * 5.0) + 10.0;
    }
}

class InternationalShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        // International shipping: $8 per kg + $20 handling
        return (weight * 8.0) + 20.0;
    }
}

class EconomyShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        // Economy shipping: $1 per kg + $5 handling
        return (weight * 1.0) + 5.0;
    }
}

class ShippingCalculator {
    private ShippingStrategy strategy;
    
    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }
    
    public double calculateCost(double weight) {
        if (strategy == null) {
            throw new IllegalStateException("Shipping strategy not set");
        }
        return strategy.calculateCost(weight);
    }
}

class Main {
    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator();
        double weight = 5.0; // 5 kg package
        
        // Calculate standard shipping
        calculator.setStrategy(new StandardShipping());
        System.out.println("Standard shipping cost: $" + 
            calculator.calculateCost(weight));
        
        // Calculate express shipping
        calculator.setStrategy(new ExpressShipping());
        System.out.println("Express shipping cost: $" + 
            calculator.calculateCost(weight));
        
        // Calculate international shipping
        calculator.setStrategy(new InternationalShipping());
        System.out.println("International shipping cost: $" + 
            calculator.calculateCost(weight));
        
        // Easily add new shipping method
        calculator.setStrategy(new EconomyShipping());
        System.out.println("Economy shipping cost: $" + 
            calculator.calculateCost(weight));
    }
}