// Without Mediator Pattern
class Student {
    private String name;
    private List<Student> colleagues;
    
    public Student(String name) {
        this.name = name;
        this.colleagues = new ArrayList<>();
    }
    
    public void addColleague(Student student) {
        if (!colleagues.contains(student)) {
            colleagues.add(student);
            student.addColleague(this);
        }
    }
    
    public void sendMessage(String message) {
        for (Student colleague : colleagues) {
            colleague.receiveMessage(this.name, message);
        }
    }
    
    public void receiveMessage(String from, String message) {
        System.out.println(name + " received from " + from + ": " + message);
    }
}

class Main {
    public static void main(String[] args) {
        Student john = new Student("John");
        Student emma = new Student("Emma");
        Student mike = new Student("Mike");
        
        john.addColleague(emma);
        john.addColleague(mike);
        emma.addColleague(mike);
        emma.addColleague(john);
        mike.addColleague(emma);
        mike.addColleague(john);
        
        john.sendMessage("Hey everyone!");
        emma.sendMessage("Hi John!");
        mike.sendMessage("Hello!");
    }
}