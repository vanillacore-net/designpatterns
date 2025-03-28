// With Mediator Pattern
interface ChatMediator {
    void sendMessage(String message, Student student);
    void addStudent(Student student);
}

class GroupChat implements ChatMediator {
    private List<Student> students;
    
    public GroupChat() {
        this.students = new ArrayList<>();
    }
    
    @Override
    public void addStudent(Student student) {
        students.add(student);
    }
    
    @Override
    public void sendMessage(String message, Student sender) {
        for (Student student : students) {
            // Don't send message back to sender
            if (student != sender) {
                student.receiveMessage(sender.getName(), message);
            }
        }
    }
}

class Student {
    private String name;
    private ChatMediator mediator;
    
    public Student(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.addStudent(this);
    }
    
    public String getName() {
        return name;
    }
    
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }
    
    public void receiveMessage(String from, String message) {
        System.out.println(name + " received from " + from + ": " + message);
    }
}

class Main {
    public static void main(String[] args) {
        ChatMediator groupChat = new GroupChat();
        
        Student john = new Student("John", groupChat);
        Student emma = new Student("Emma", groupChat);
        Student mike = new Student("Mike", groupChat);
        
        john.sendMessage("Hey everyone!");
        emma.sendMessage("Hi John!");
        mike.sendMessage("Hello!");

        groupChat.sendMessage("Huhu", john);
    }
}