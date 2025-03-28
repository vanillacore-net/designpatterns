// WITHOUT DECORATOR PATTERN
class Coffee {
    private boolean hasMilk;
    private boolean hasWhip;
    private boolean hasSyrup;
    
    // Complex constructor with many parameters
    public Coffee(boolean hasMilk, boolean hasWhip, boolean hasSyrup) {
        this.hasMilk = hasMilk;
        this.hasWhip = hasWhip;
        this.hasSyrup = hasSyrup;
    }
    
    public double getCost() {
        double cost = 2.0; // Base coffee cost
        if (hasMilk) cost += 0.5;
        if (hasWhip) cost += 0.7;
        if (hasSyrup) cost += 0.5;
        return cost;
    }
    
    public String getDescription() {
        StringBuilder desc = new StringBuilder("Coffee");
        if (hasMilk) desc.append(" + milk");
        if (hasWhip) desc.append(" + whip");
        if (hasSyrup) desc.append(" + syrup");
        return desc.toString();
    }
}

// Client code WITHOUT pattern - Problems:
class Client {
    public static void main(String[] args) {
        // Need different combinations? Create new objects
        Coffee simpleCoffee = new Coffee(false, false, false);
        Coffee coffeeWithMilk = new Coffee(true, false, false);
        Coffee fullCoffee = new Coffee(true, true, true);
        
        System.out.println(simpleCoffee.getDescription() + " costs $" + simpleCoffee.getCost());
        System.out.println(fullCoffee.getDescription() + " costs $" + fullCoffee.getCost());
    }
}