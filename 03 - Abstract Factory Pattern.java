// Product interfaces
public interface Chair {
    void sitOn();
}

public interface Table {
    void putOn();
}

// Concrete Modern products
class ModernChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on modern chair");
    }
}

class ModernTable implements Table {
    public void putOn() {
        System.out.println("Putting on modern table");
    }
}

// Concrete Victorian products
class VictorianChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on victorian chair");
    }
}

class VictorianTable implements Table {
    public void putOn() {
        System.out.println("Putting on victorian table");
    }
}

// Abstract Factory interface
public interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}

// Concrete Factories
class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ModernChair();
    }
    
    public Table createTable() {
        return new ModernTable();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new VictorianChair();
    }
    
    public Table createTable() {
        return new VictorianTable();
    }
}

/**
 * Factory for Factory :-)
 */
public class FurnitureFactoryFactory {

    public static FurnitureFactory createFactory(String kind) {
        if(kind.equalsIgnoreCase() == 'modern') {
            return new ModernFurnitureFactory();            
        }

        return new VictorianFurnitureFactory();
    }
}

class ClientWithPattern {
    public static void main(String[] args) {
        // Create a modern furniture set
        FurnitureFactory factory = 
            FurnitureFactoryFactory.createFactory('modern');
        Chair modernChair = factory.createChair();
        Table modernTable = factory.createTable();
        
        // Everything matches by design
        modernChair.sitOn();
        modernTable.putOn();
        
        // Create a victorian furniture set
        FurnitureFactory factory = 
            FurnitureFactoryFactory.createFactory('victorian');

        Chair victorianChair = factory.createChair();
        Table victorianTable = factory.createTable();
        
        victorianChair.sitOn();
        victorianTable.putOn();
    }
}