// State interface
interface PackageState {
    void process(Package pkg);
    void ship(Package pkg);
    void deliver(Package pkg);
    String getStatus();
}

// Concrete states
class OrderedState implements PackageState {
    public void process(Package pkg) {
        pkg.setState(new ProcessingState());
        System.out.println("Package " + pkg.getTrackingNumber() + ": Processing order...");
    }
    
    public void ship(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Can't ship - not processed yet!");
    }
    
    public void deliver(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Can't deliver - not shipped yet!");
    }
    
    public String getStatus() {
        return "ordered";
    }
}

class ProcessingState implements PackageState {
    public void process(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Already processing!");
    }
    
    public void ship(Package pkg) {
        pkg.setState(new ShippedState());
        System.out.println("Package " + pkg.getTrackingNumber() + ": Package shipped!");
    }
    
    public void deliver(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Can't deliver - not shipped yet!");
    }
    
    public String getStatus() {
        return "processing";
    }
}

class ShippedState implements PackageState {
    public void process(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Already processed!");
    }
    
    public void ship(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Already shipped!");
    }
    
    public void deliver(Package pkg) {
        pkg.setState(new DeliveredState());
        System.out.println("Package " + pkg.getTrackingNumber() + ": Package delivered!");
    }
    
    public String getStatus() {
        return "shipped";
    }
}

class DeliveredState implements PackageState {
    public void process(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Package already delivered!");
    }
    
    public void ship(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Package already delivered!");
    }
    
    public void deliver(Package pkg) {
        System.out.println("Package " + pkg.getTrackingNumber() + ": Package already delivered!");
    }
    
    public String getStatus() {
        return "delivered";
    }
}

class Package {
    private PackageState state;
    private String trackingNumber;
    
    public Package(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        this.state = new OrderedState();
    }
    
    public void setState(PackageState state) {
        this.state = state;
    }
    
    public String getTrackingNumber() {
        return trackingNumber;
    }
    
    public void process() {
        state.process(this);
    }
    
    public void ship() {
        state.ship(this);
    }
    
    public void deliver() {
        state.deliver(this);
    }
    
    public String getStatus() {
        return "Package " + trackingNumber + " is currently " + state.getStatus();
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
        
        // Try invalid operations
        pkg.process(); // Will show appropriate message
        pkg.ship();    // Will show appropriate message
    }
}