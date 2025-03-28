// Imagine a printer spooler that manages print jobs in an office.
// Without Singleton - PROBLEMATIC:
public class PrinterSpooler {
    private Queue<String> printQueue = new LinkedList<>();
    
    public PrinterSpooler() {
        // Each instance creates its own queue
    }
    
    public void addJob(String document) {
        printQueue.add(document);
        System.out.println("Added: " + document);
    }
    
    public void printNext() {
        String doc = printQueue.poll();
        if (doc != null) {
            System.out.println("Printing: " + doc);
        }
    }
}

// PROBLEM DEMONSTRATION:
PrinterSpooler spooler1 = new PrinterSpooler();
PrinterSpooler spooler2 = new PrinterSpooler();

spooler1.addJob("Document1.pdf");  // Goes to queue 1
spooler2.addJob("Document2.pdf");  // Goes to queue 2!