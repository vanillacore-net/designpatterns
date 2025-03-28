// WITHOUT PROXY PATTERN
class Image {
    private String filename;
    
    public Image(String filename) {
        this.filename = filename;
        loadImage();  // Heavy operation done immediately
    }
    
    private void loadImage() {
        System.out.println("Loading image " + filename + " from disk...");
        // Simulate heavy image loading
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class Client {
    public static void main(String[] args) {
        System.out.println("Creating image gallery...");
        Image image1 = new Image("photo1.jpg");
        Image image2 = new Image("photo2.jpg");
        Image image3 = new Image("photo3.jpg");
        
        image1.display();
    }
}