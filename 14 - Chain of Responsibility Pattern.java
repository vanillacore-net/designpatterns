// WITH CHAIN OF RESPONSIBILITY PATTERN
class SupportTicket {
    private String type;
    private int severity;
    
    public SupportTicket(String type, int severity) {
        this.type = type;
        this.severity = severity;
    }
    
    public String getType() { return type; }
    public int getSeverity() { return severity; }
}

// Handler interface
abstract class SupportHandler {
    protected SupportHandler nextHandler;
    
    public void setNext(SupportHandler handler) {
        this.nextHandler = handler;
    }
    
    public abstract void handleRequest(SupportTicket ticket);
}

// Concrete handlers
class FirstLevelSupport extends SupportHandler {
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getType().equals("Technical") && ticket.getSeverity() <= 1) {
            System.out.println("First Level Support: Handling basic technical issue");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
    }
}

class TechnicalSpecialist extends SupportHandler {
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getType().equals("Technical") && ticket.getSeverity() <= 3) {
            System.out.println("Technical Specialist: Handling complex technical issue");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
    }
}

class BillingSupport extends SupportHandler {
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getType().equals("Billing") && ticket.getSeverity() <= 2) {
            System.out.println("Billing Support: Handling billing issue");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
    }
}

class Manager extends SupportHandler {
    public void handleRequest(SupportTicket ticket) {
        System.out.println("Manager: Handling escalated issue");
    }
}

// Client code WITH pattern
class Client { 
    public static void main(String[] args) {
        // Create the chain
        FirstLevelSupport firstLevel = new FirstLevelSupport();
        TechnicalSpecialist techSpecialist = new TechnicalSpecialist();
        BillingSupport billingSupport = new BillingSupport();
        Manager manager = new Manager();
        
        // Set up the chain
        firstLevel.setNext(techSpecialist);
        techSpecialist.setNext(billingSupport);
        billingSupport.setNext(manager);
        
        // Create and process tickets
        SupportTicket ticket1 = new SupportTicket("Technical", 1);
        SupportTicket ticket2 = new SupportTicket("Billing", 2);
        SupportTicket ticket3 = new SupportTicket("Technical", 3);
        
        // Process tickets through the chain
        firstLevel.handleRequest(ticket1);
        firstLevel.handleRequest(ticket2);
        firstLevel.handleRequest(ticket3);
    }
}