// Image interface
interface Image {
    void display();
}

// Real image - heavy object
class RealImage implements Image {
    private String filename;
    
    public RealImage(String filename) {
        this.filename = filename;
        loadImage();
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
    
    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// Proxy
class ImageProxy implements Image {
    private String filename;
    private RealImage realImage;
    
    public ImageProxy(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void display() {
        // Load the image only when needed
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code WITH pattern
class ClientWithProxy {
    public static void main(String[] args) {
        // Creating proxies is very fast - no loading occurs
        System.out.println("Creating image gallery...");
        Image image1 = new ImageProxy("photo1.jpg");
        Image image2 = new ImageProxy("photo2.jpg");
        Image image3 = new ImageProxy("photo3.jpg");
        
        // Image is loaded only when displayed
        System.out.println("\nUser opens first image:");
        image1.display();
        
        System.out.println("\nOpening first image again (already loaded):");
        image1.display();
        
        // Other images never loaded unless displayed
    }
}