class ModernChair {
    public void sitOn() {
        System.out.println("Sitting on modern chair");
    }
}

class ModernTable {
    public void putOn() {
        System.out.println("Putting on modern table");
    }
}

class VictorianChair {
    public void sitOn() {
        System.out.println("Sitting on victorian chair");
    }
}

class VictorianTable {
    public void putOn() {
        System.out.println("Putting on victorian table");
    }
}

class ClientWithoutPattern {
    public static void main(String[] args) {
        ModernChair chair1 = new ModernChair();
        VictorianTable table1 = new VictorianTable();  // Oops! Mixed styles!
        
        chair1.sitOn();
        table1.putOn();
    }
}