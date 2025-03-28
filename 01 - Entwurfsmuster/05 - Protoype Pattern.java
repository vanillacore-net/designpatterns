interface Shape extends Cloneable {
    Shape clone();
    void setX(int x);
    void setY(int y);
}

class Circle implements Shape {
    private int x;
    private int y;
    private String color;
    
    public Circle(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    @Override
    public Shape clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    @Override
    public void setX(int x) {
        this.x = x;
    }
    
    @Override
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Circle [x=" + x + ", y=" + y + ", color=" + color + "]";
    }
}

class Client {
    public static void main(String[] args) {
        Circle originalCircle = new Circle(10, 20, "red");
        
        // Clone
        Shape clonedCircle = originalCircle.clone();
        
        // Modify clone
        clonedCircle.setX(30);
        clonedCircle.setY(40);
        
        System.out.println("Original: " + originalCircle);
        System.out.println("Clone: " + clonedCircle);
    }
}