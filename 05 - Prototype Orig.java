class Shape {
    private int x;
    private int y;
    private String color;
    
    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    // Copying
    public Shape copy() {
        return new Shape(this.x, this.y, this.color);
    }

    @Override
    public String toString() {
        return "Circle [x=" + x + ", y=" + y + ", color=" + color + "]";
    }
}

class Client {
    public static void main(String[] args) {
        Shape original = new Shape(10, 20, "red");
        
        Shape copy = original.copy();

        // Modify clone
        copy.setX(30);
        copy.setY(40);
        
        System.out.println("Original: " + originalCircle);
        System.out.println("Clone: " + copy);
    }
}
