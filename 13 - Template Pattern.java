// WITH TEMPLATE PATTERN
abstract class BeverageTemplate {
    // Template method - final so it can't be overridden
    public final void prepareBeverage() {
        boilWater();         // Common step
        brew();              // Abstract step
        pourInCup();         // Common step
        if (customerWantsCondiments()) {  // Hook
            addCondiments(); // Abstract step
        }
    }
    
    // Common methods
    private void boilWater() {
        System.out.println("Boiling water");
    }
    
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract void brew();
    protected abstract void addCondiments();
    
    // Hook method - can be overridden
    protected boolean customerWantsCondiments() {
        return true;
    }
}

class Coffee extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Brewing coffee");
    }
    
    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

class Tea extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Steeping tea");
    }
    
    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
    
    @Override
    protected boolean customerWantsCondiments() {
        return false;  // Tea without condiments
    }
}

// Client code WITH pattern
class Client {
    public static void main(String[] args) {
        BeverageTemplate coffee = new Coffee();
        BeverageTemplate tea = new Tea();
        
        System.out.println("Making coffee:");
        coffee.prepareBeverage();
        
        System.out.println("\nMaking tea:");
        tea.prepareBeverage();
    }
}