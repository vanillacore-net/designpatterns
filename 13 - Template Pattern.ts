// Abstract base class for beverages
abstract class BeverageTemplate {
    // Template method - final in TypeScript by default
    public prepareBeverage(): void {
        this.boilWater();    // Common step
        this.brew();         // Abstract step
        this.pourInCup();    // Common step
        if (this.customerWantsCondiments()) {  // Hook
            this.addCondiments(); // Abstract step
        }
    }
    
    // Common methods
    private boilWater(): void {
        console.log("Boiling water");
    }
    
    private pourInCup(): void {
        console.log("Pouring into cup");
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract brew(): void;
    protected abstract addCondiments(): void;
    
    // Hook method - can be overridden
    protected customerWantsCondiments(): boolean {
        return true;
    }
}

class Coffee extends BeverageTemplate {
    protected brew(): void {
        console.log("Brewing coffee");
    }
    
    protected addCondiments(): void {
        console.log("Adding sugar and milk");
    }
}

class Tea extends BeverageTemplate {
    protected brew(): void {
        console.log("Steeping tea");
    }
    
    protected addCondiments(): void {
        console.log("Adding lemon");
    }
    
    protected customerWantsCondiments(): boolean {
        return false;  // Tea without condiments
    }
}

// Client code
class ClientWithTemplate {
    public static main(): void {
        const coffee: BeverageTemplate = new Coffee();
        const tea: BeverageTemplate = new Tea();
        
        console.log("Making coffee:");
        coffee.prepareBeverage();
        
        console.log("\nMaking tea:");
        tea.prepareBeverage();
    }
}

// Execute the client code
ClientWithTemplate.main();