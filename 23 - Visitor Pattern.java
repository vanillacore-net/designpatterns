// Visitor interface
interface AssignmentVisitor {
    void visit(Essay essay);
    void visit(MathTest mathTest);
}

// Element interface
interface AssignmentElement {
    void accept(AssignmentVisitor visitor);
}

class Assignment {
    private String studentName;
    private int score;
    
    public Assignment(String studentName, int score) {
        this.studentName = studentName;
        this.score = score;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public int getScore() {
        return score;
    }
}

class Essay extends Assignment implements AssignmentElement {
    private int grammarScore;
    private int contentScore;
    
    public Essay(String studentName, int grammarScore, int contentScore) {
        super(studentName, grammarScore + contentScore);
        this.grammarScore = grammarScore;
        this.contentScore = contentScore;
    }
    
    public int getGrammarScore() {
        return grammarScore;
    }
    
    public int getContentScore() {
        return contentScore;
    }
    
    @Override
    public void accept(AssignmentVisitor visitor) {
        visitor.visit(this);
    }
}

class MathTest extends Assignment implements AssignmentElement {
    private int correctAnswers;
    private int totalQuestions;
    
    public MathTest(String studentName, int correctAnswers, int totalQuestions) {
        super(studentName, (correctAnswers * 100) / totalQuestions);
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
    }
    
    public int getCorrectAnswers() {
        return correctAnswers;
    }
    
    public int getTotalQuestions() {
        return totalQuestions;
    }
    
    @Override
    public void accept(AssignmentVisitor visitor) {
        visitor.visit(this);
    }
}

// Concrete visitor for grading
class GradingVisitor implements AssignmentVisitor {

    @Override
    public void visit(Essay essay) {
        int total = essay.getGrammarScore() + essay.getContentScore();
        String grade = calculateGrade(total);
        System.out.println("Student: " + essay.getStudentName());
        System.out.println("Essay Grade: " + grade);
        System.out.println("Grammar: " + essay.getGrammarScore());
        System.out.println("Content: " + essay.getContentScore());
        System.out.println();
    }
    
    @Override
    public void visit(MathTest mathTest) {
        int percentage = (mathTest.getCorrectAnswers() * 100) / mathTest.getTotalQuestions();
        String grade = calculateGrade(percentage);
        System.out.println("Student: " + mathTest.getStudentName());
        System.out.println("Math Test Grade: " + grade);
        System.out.println("Score: " + mathTest.getCorrectAnswers() + "/" + mathTest.getTotalQuestions());
        System.out.println();
    }
    
    private String calculateGrade(int score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        return "F";
    }
}

// Different visitor for generating feedback
class FeedbackVisitor implements AssignmentVisitor {
    @Override
    public void visit(Essay essay) {
        System.out.println("Feedback for " + essay.getStudentName() + "'s essay:");
        if (essay.getGrammarScore() < 40) {
            System.out.println("- Need to improve grammar");
        }
        if (essay.getContentScore() < 40) {
            System.out.println("- Content needs more depth");
        }
        System.out.println();
    }
    
    @Override
    public void visit(MathTest mathTest) {
        System.out.println("Feedback for " + mathTest.getStudentName() + "'s math test:");
        double accuracy = (double) mathTest.getCorrectAnswers() / mathTest.getTotalQuestions();
        if (accuracy < 0.7) {
            System.out.println("- More practice needed");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        List<AssignmentElement> assignments = new ArrayList<>();
        assignments.add(new Essay("John", 45, 45));        // 90 total
        assignments.add(new MathTest("Alice", 9, 10));     // 90%
        
        // Using grading visitor
        AssignmentVisitor gradingVisitor = new GradingVisitor();
        System.out.println("Grading Assignments:");
        for (AssignmentElement assignment : assignments) {
            assignment.accept(gradingVisitor);
        }
        
        // Using feedback visitor
        AssignmentVisitor feedbackVisitor = new FeedbackVisitor();
        System.out.println("Generating Feedback:");
        for (AssignmentElement assignment : assignments) {
            assignment.accept(feedbackVisitor);
        }
    }
}