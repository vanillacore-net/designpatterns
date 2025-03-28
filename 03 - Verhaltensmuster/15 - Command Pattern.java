// Step 1: Command interface
interface Command {
    void execute();
}

// Step 2: Concrete Commands
class LightOnCommand implements Command {
    private Light light;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;
    
    public LightOffCommand(Light light) {
        this.light = light;
    }
    
    public void execute() {
        light.turnOff();
    }
}

class FanOnCommand implements Command {
    private Fan fan;
    
    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }
    
    public void execute() {
        fan.turnOn();
    }
}

class FanOffCommand implements Command {
    private Fan fan;
    
    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }
    
    public void execute() {
        fan.turnOff();
    }
}

// Step 3: Receiver classes
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

// Step 4: Invoker
class RemoteControlWithCommand {
    private Command[] commands = new Command[4];
    
    public void setCommand(int slot, Command command) {
        commands[slot] = command;
    }
    
    public void buttonPressed(int slot) {
        if (commands[slot] != null) {
            commands[slot].execute();
        }
    }
}

// Usage example
class Main {
    public static void main(String[] args) {
        // Create receivers
        Light light = new Light();
        Fan fan = new Fan();
        
        // Create commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);
        
        // Set up remote control
        RemoteControlWithCommand remote = new RemoteControlWithCommand();
        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);
        remote.setCommand(2, fanOn);
        remote.setCommand(3, fanOff);
        
        // Use remote
        remote.buttonPressed(0); // Light turns on
        remote.buttonPressed(1); // Fan turns on
        remote.buttonPressed(2); // Light turns off
        remote.buttonPressed(3); // Fan turns off
    }
}