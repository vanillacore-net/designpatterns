// Bridge: Color is an independent abstraction.
interface Color {
    void applyColor();
}

class Red implements Color {
    @Override
    public void applyColor() {
        System.out.println("red color");
    }
}

class Blue implements Color {
    @Override
    public void applyColor() {
        System.out.println("blue color");
    }
}

class Green implements Color {
    @Override
    public void applyColor() {
        System.out.println("green color");
    }
}

// Abstraction: Style connects to Color via the bridge.
abstract class Garment {
    protected Color color; // Bridge to the implementation

    public Garment(Color color) {
        this.color = color;
    }

    abstract void wear();
}

// Refined Abstractions: Specific styles.
class Dress extends Garment {
    public Dress(Color color) {
        super(color);
    }

    @Override
    public void wear() {
        System.out.print("Wearing a dress in ");
        color.applyColor();
    }
}

class Shirt extends Garment {
    public Shirt(Color color) {
        super(color);
    }

    @Override
    public void wear() {
        System.out.print("Wearing a shirt in ");
        color.applyColor();
    }
}

public class Main {
    public static void main(String[] args) {
        // Styling the garments
        Garment redDress = new Dress(new Red());
        Garment blueShirt = new Shirt(new Blue());
        Garment greenDress = new Dress(new Green());

        redDress.wear(); // Output: Wearing a dress in red color
        blueShirt.wear(); // Output: Wearing a shirt in blue color
        greenDress.wear();
    }
}
