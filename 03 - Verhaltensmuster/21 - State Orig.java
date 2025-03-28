class Package {
    private String currentState; // "ordered", "processing", "shipped", "delivered"
    private String trackingNumber;
    
    public Package(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        this.currentState = "ordered";
    }
    
    public void process() {
        if (currentState.equals("ordered")) {
            currentState = "processing";
            System.out.println("Package " + trackingNumber + ": Processing order...");
        } else {
            System.out.println("Package " + trackingNumber + ": Can't process - invalid state!");
        }
    }
    
    public void ship() {
        if (currentState.equals("processing")) {
            currentState = "shipped";
            System.out.println("Package " + trackingNumber + ": Package shipped!");
        } else {
            System.out.println("Package " + trackingNumber + ": Can't ship - not processed yet!");
        }
    }
    
    public void deliver() {
        if (currentState.equals("shipped")) {
            currentState = "delivered";
            System.out.println("Package " + trackingNumber + ": Package delivered!");
        } else {
            System.out.println("Package " + trackingNumber + ": Can't deliver - not shipped yet!");
        }
    }
    
    public String getStatus() {
        return "Package " + trackingNumber + " is currently " + currentState;
    }
}

class Main {
    public static void main(String[] args) {
        Package pkg = new Package("12345");
        
        System.out.println(pkg.getStatus());
        
        pkg.process();
        System.out.println(pkg.getStatus());
        
        pkg.ship();
        System.out.println(pkg.getStatus());
        
        pkg.deliver();
        System.out.println(pkg.getStatus());
        
        // Try invalid operation
        pkg.process(); // Will show error message
    }
}