// Implementation interface
interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}

// Concrete implementations
class SonyDevice implements Device {
    public void turnOn() {
        System.out.println("Sony TV: turning on");
    }
    
    public void turnOff() {
        System.out.println("Sony TV: turning off");
    }
    
    public void setChannel(int channel) {
        System.out.println("Sony TV: setting channel " + channel);
    }
}

class SamsungDevice implements Device {
    public void turnOn() {
        System.out.println("Samsung TV: turning on");
    }
    
    public void turnOff() {
        System.out.println("Samsung TV: turning off");
    }
    
    public void setChannel(int channel) {
        System.out.println("Samsung TV: setting channel " + channel);
    }
}

// Abstraction
abstract class Remote {
    protected Device device;
    
    public Remote(Device device) {
        this.device = device;
    }
    
    abstract void togglePower();
}

// Refined Abstractions
class BasicRemote extends Remote {
    public BasicRemote(Device device) {
        super(device);
    }
    
    public void togglePower() {
        System.out.println("Basic Remote: toggle power");
        device.turnOn();
    }
}

class AdvancedRemote extends Remote {
    public AdvancedRemote(Device device) {
        super(device);
    }
    
    public void togglePower() {
        System.out.println("Advanced Remote: toggle power");
        device.turnOn();
    }
    
    public void setChannel(int channel) {
        device.setChannel(channel);
    }
}

// Client code WITH pattern
class ClientWithBridge {
    public static void main(String[] args) {
        Device sony = new SonyDevice();
        Device samsung = new SamsungDevice();
        
        Remote basicRemote = new BasicRemote(sony);
        Remote advancedRemote = new AdvancedRemote(samsung);
        
        // Can mix and match any remote with any device
        basicRemote.togglePower();
        ((AdvancedRemote) advancedRemote).setChannel(5);
    }
}