// WITHOUT TEMPLATE PATTERN
class Coffee {
    public void prepareCoffee() {
        boilWater();
        brewCoffee();
        pourInCup();
        addSugar();
        addMilk();
    }
    
    private void boilWater() {
        System.out.println("Boiling water");
    }
    
    private void brewCoffee() {
        System.out.println("Brewing coffee");
    }
    
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
    
    private void addSugar() {
        System.out.println("Adding sugar");
    }
    
    private void addMilk() {
        System.out.println("Adding milk");
    }
}

class Tea {
    public void prepareTea() {
        boilWater();         
        steepTea();
        pourInCup();         
        addLemon();
    }
    
    private void boilWater() {
        System.out.println("Boiling water");    
    }
    
    private void steepTea() {
        System.out.println("Steeping tea");
    }
    
    private void pourInCup() {
        System.out.println("Pouring into cup");  
    }
    
    private void addLemon() {
        System.out.println("Adding lemon");
    }
}

// Client code WITHOUT pattern
class Client {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
        
        System.out.println("Making coffee:");
        coffee.prepareCoffee();
        
        System.out.println("\nMaking tea:");
        tea.prepareTea();
    }
}