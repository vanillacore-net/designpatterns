// Base Component interface
interface Coffee {
    double getCost();
    String getDescription();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0;
    }
    
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

// Base Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
    
    public double getCost() {
        return decoratedCoffee.getCost();
    }
    
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + milk";
    }
}

class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 0.7;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + whip";
    }
}

// Client code WITH pattern
class Client {
    public static void main(String[] args) {
        // Basic coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " costs $" + coffee.getCost());
        
        // Decorate it with milk
        Coffee coffeeWithMilk = 
            new MilkDecorator(coffee);
        System.out.println(coffeeWithMilk.getDescription() + " costs $" + coffeeWithMilk.getCost());
        
        // Add whip to coffee with milk
        Coffee coffeeWithMilkAndWhip = 
            new WhipDecorator(coffeeWithMilk);
        System.out.println(coffeeWithMilkAndWhip.getDescription() + " costs $" + coffeeWithMilkAndWhip.getCost());
    }
}