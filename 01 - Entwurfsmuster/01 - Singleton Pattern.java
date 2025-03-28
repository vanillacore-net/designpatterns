// With Singleton - SOLUTION:
public class PrinterSpoolerSingleton {
    private static PrinterSpoolerSingleton instance;
    private Queue<String> printQueue = new LinkedList<>();
    
    private PrinterSpoolerSingleton() {
        // Private constructor ensures single queue
    }
    
    public static PrinterSpoolerSingleton getInstance() {
        if (instance == null) {
            instance = new PrinterSpoolerSingleton();
        }
        return instance;
    }
    
    public void addJob(String document) {
        printQueue.add(document);
        System.out.println("Added to single queue: " + document);
    }
    
    public void printNext() {
        String doc = printQueue.poll();
        if (doc != null) {
            System.out.println("Printing from single queue: " + doc);
        }
    }
}

// SOLUTION DEMONSTRATION:
PrinterSpoolerSingleton spooler1 = PrinterSpoolerSingleton.getInstance();
PrinterSpoolerSingleton spooler2 = PrinterSpoolerSingleton.getInstance();

spooler1.addJob("Document1.pdf");  // Goes to shared queue
spooler2.addJob("Document2.pdf");  // Goes to SAME queue