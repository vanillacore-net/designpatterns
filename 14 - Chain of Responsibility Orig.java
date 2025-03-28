class SupportTicket {
    private String type;
    private int severity;
    
    public SupportTicket(String type, int severity) {
        this.type = type;
        this.severity = severity;
    }
    
    public void processSupportRequest() {
        if (type.equals("Technical") && severity <= 1) {
            System.out.println("First Level Support: Handling basic technical issue");
        } 
        else if (type.equals("Technical") && severity <= 3) {
            System.out.println("Technical Specialist: Handling complex technical issue");
        }
        else if (type.equals("Billing") && severity <= 2) {
            System.out.println("Billing Support: Handling billing issue");
        }
        else {
            System.out.println("Manager: Handling escalated issue");
        }
    }
}

class Client {
    public static void main(String[] args) {
        SupportTicket ticket1 = new SupportTicket("Technical", 1);
        SupportTicket ticket2 = new SupportTicket("Billing", 2);
        SupportTicket ticket3 = new SupportTicket("Technical", 3);
        
        ticket1.processSupportRequest();
        ticket2.processSupportRequest();
        ticket3.processSupportRequest();
    }
}