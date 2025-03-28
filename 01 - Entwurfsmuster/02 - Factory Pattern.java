// Base shape interface
interface Shape {
    void draw();
}

// Concrete shapes
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Factory
class ShapeFactory {
    
    public static Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(); 
        }
        if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

class Client {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("CIRCLE");
        Shape square = ShapeFactory.createShape("SQUARE");
        
        circle.draw();
        square.draw();
    }
}