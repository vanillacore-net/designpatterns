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

class Client {
    public static void main(String[] args) {
        Shape circle = new Circle();  
        Shape square = new Square(); 

        circle.draw();
        square.draw();
    }
}