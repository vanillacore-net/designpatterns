// Base class for garments
abstract class Garment {
    abstract void wear();
}

// Tightly coupled combinations
class RedDress extends Garment {
    @Override
    void wear() {
        System.out.println("Wearing a red dress");
    }
}

class BlueDress extends Garment {
    @Override
    void wear() {
        System.out.println("Wearing a blue dress");
    }
}

class RedShirt extends Garment {
    @Override
    void wear() {
        System.out.println("Wearing a red shirt");
    }
}

class BlueShirt extends Garment {
    @Override
    void wear() {
        System.out.println("Wearing a blue shirt");
    }
}

// Imagine more colors like Green, Yellow
class GreenDress extends Garment {
    @Override
    void wear() {
        System.out.println("Wearing a green dress");
    }
}

class YellowShirt extends Garment {
    @Override
    void wear() {
        System.out.println("Wearing a yellow shirt");
    }
}

public class Main {
    public static void main(String[] args) {
        // Instantiate each style-color combination
        Garment redDress = new RedDress();
        Garment blueShirt = new BlueShirt();
        Garment greenDress = new GreenDress();
        Garment yellowShirt = new YellowShirt();

        // Call the wear() method on each instance
        redDress.wear();  // Output: Wearing a red dress
        blueShirt.wear(); // Output: Wearing a blue shirt
        greenDress.wear(); // Output: Wearing a green dress
        yellowShirt.wear(); // Output: Wearing a yellow shirt
    }
}
