// WITHOUT COMPOSITE PATTERN
class File {
    private String name;
    private int size;
    
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    public void showDetails() {
        System.out.println("File: " + name + " (" + size + "KB)");
    }
    
    public int getSize() {
        return size;
    }
}

class Directory {
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Directory> directories = new ArrayList<>();
    
    public Directory(String name) {
        this.name = name;
    }
    
    public void addFile(File file) {
        files.add(file);
    }
    
    public void addDirectory(Directory dir) {
        directories.add(dir);
    }
    
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (File file : files) {
            file.showDetails();
        }
        for (Directory dir : directories) {
            dir.showDetails();
        }
    }
    
    public int getSize() {
        int totalSize = 0;
        for (File file : files) {
            totalSize += file.getSize();
        }
        for (Directory dir : directories) {
            totalSize += dir.getSize();
        }
        return totalSize;
    }
}

class ClientWithoutComposite {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.addFile(new File("config.xml", 100));
        
        Directory docs = new Directory("documents");
        docs.addFile(new File("resume.pdf", 200));
        
        root.addDirectory(docs);
        root.showDetails();
    }
}