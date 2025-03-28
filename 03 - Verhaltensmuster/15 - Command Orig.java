class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }
    
    public void turnOff() {
        System.out.println("Light is off");
    }
}

class Fan {
    public void turnOn() {
        System.out.println("Fan is on");
    }
    
    public void turnOff() {
        System.out.println("Fan is off");
    }
}

class RemoteControl {
    private Light light;
    private Fan fan;
    
    public RemoteControl() {
        light = new Light();
        fan = new Fan();
    }
    
    public void buttonPressed(int slot) {
        if (slot == 1) {
            light.turnOn();
        } else if (slot == 2) {
            light.turnOff();
        } else if (slot == 3) {
            fan.turnOn();
        } else if (slot == 4) {
            fan.turnOff();
        }
    }
}

// Usage example
class Main {
    public static void main(String[] args) {
        // Set up remote control
        RemoteControl remote = new RemoteControl();
        
        // Use remote
        remote.buttonPressed(0); // Light turns on
        remote.buttonPressed(2); // Fan turns on
        remote.buttonPressed(1); // Light turns off
        remote.buttonPressed(3); // Fan turns off
    }
}