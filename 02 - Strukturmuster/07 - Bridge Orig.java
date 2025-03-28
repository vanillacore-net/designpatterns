// Each combination needs its own class
class SonyTV {
    void turnOn() {
        System.out.println("Sony TV: turning on");
    }
    
    void turnOff() {
        System.out.println("Sony TV: turning off");
    }
}

class SonyAdvancedRemote {
    private SonyTV tv;
    
    public SonyAdvancedRemote(SonyTV tv) {
        this.tv = tv;
    }
    
    void turnOn() {
        tv.turnOn();
    }
    
    void turnOff() {
        tv.turnOff();
    }
    
    void setChannel(int channel) {
        System.out.println("Sony TV: setting channel " + channel);
    }
}

class SonyBasicRemote {
    private SonyTV tv;
    
    public SonyBasicRemote(SonyTV tv) {
        this.tv = tv;
    }
    
    void turnOn() {
        tv.turnOn();
    }
    
    void turnOff() {
        tv.turnOff();
    }
}

// Client code WITHOUT pattern - Problems:
class ClientWithoutBridge {
    public static void main(String[] args) {
        SonyTV sony = new SonyTV();
        SonyBasicRemote basicRemote = new SonyBasicRemote(sony);
        SonyAdvancedRemote advancedRemote = new SonyAdvancedRemote(sony);

        SamsungTV samsung = new SamsungTV();
        SamsungBasicRemote samsungBasicRemote = new SamsungBasicRemote(sony);
        SamsungAdvancedRemote samsungAdvancedRemote = new SamsungAdvancedRemote(sony);
        
        // Need different classes for each TV-remote combination
        basicRemote.turnOn();
        advancedRemote.setChannel(5);

        samsungBasicRemote.turnOn();
        samsungAdvancedRemote.setChannel(5);
    }
}