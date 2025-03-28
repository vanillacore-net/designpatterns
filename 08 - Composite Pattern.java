interface FileSystemComponent {
    void showDetails(String indent);
    int getSize();
}

// Leaf
class File implements FileSystemComponent {
    private String name;
    private int size;
    
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "📄 " + name + " (" + size + "KB)");
    }
    
    @Override
    public int getSize() {
        return size;
    }
}

// Composite
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> contents = new ArrayList<>();
    
    public Directory(String name) {
        this.name = name;
    }
    
    public void add(FileSystemComponent component) {
        contents.add(component);
    }
    
    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "📁 " + name + " (" + getSize() + "KB)");
        for (FileSystemComponent component : contents) {
            component.showDetails(indent + "    ");
        }
    }
    
    @Override
    public int getSize() {
        return contents.stream()
            .mapToInt(FileSystemComponent::getSize)
            .sum();
    }
}

// Client code WITH pattern
class Client {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.add(new File("config.xml", 100));
        
        Directory docs = new Directory("documents");
        docs.add(new File("resume.pdf", 200));
        docs.add(new File("photo.jpg", 2000));
        
        // Uniform handling of files and directories
        root.add(docs);
        showDetails(root);
    }

    private static void showDetails(FileSystemComponent component) {
        component.showDetails("");
        component.getSize();
    }
}