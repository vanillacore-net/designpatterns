class Pizza {
    private String dough;
    private String sauce;
    private String topping;
    
    // Constructor
    public Pizza(String dough, String sauce, String topping) {
        this.dough = dough;
        this.sauce = sauce;
        this.topping = topping;
    }
    
    // Multiple constructors for different combinations
    public Pizza(String dough, String sauce) {
        this(dough, sauce, null);
    }
    
    public String toString() {
        return "Pizza with " + dough + " dough, " + sauce + " sauce, " + 
               (topping != null ? "and " + topping : "no topping");
    }
}

class Client {
    public static void main(String[] args) {
        // Pizza 1
        Pizza pizza1 = new Pizza("thin", "tomato", "pepperoni");
        
        Pizza pizza2 = new Pizza("thick", "bbq");
        // What if we want just sauce? 
        
        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}