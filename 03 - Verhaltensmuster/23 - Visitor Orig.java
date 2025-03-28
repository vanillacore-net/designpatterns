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

class Essay extends Assignment {
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
    
    public String getGrade() {
        int total = grammarScore + contentScore;
        if (total >= 90) return "A";
        if (total >= 80) return "B";
        if (total >= 70) return "C";
        return "F";
    }
}

class MathTest extends Assignment {
    private int correctAnswers;
    private int totalQuestions;
    
    public MathTest(String studentName, int correctAnswers, int totalQuestions) {
        super(studentName, (correctAnswers * 100) / totalQuestions);
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
    }
    
    public String getGrade() {
        int percentage = (correctAnswers * 100) / totalQuestions;
        if (percentage >= 90) return "A";
        if (percentage >= 80) return "B";
        if (percentage >= 70) return "C";
        return "F";
    }
}

class GradeCalculator {
    public void processAssignments(List<Assignment> assignments) {
        for (Assignment assignment : assignments) {
            System.out.println("Student: " + assignment.getStudentName());
            
            if (assignment instanceof Essay) {
                Essay essay = (Essay) assignment;
                System.out.println("Essay Grade: " 
                    + essay.getGrade());
            } else if (assignment instanceof MathTest) {
                MathTest mathTest = (MathTest) assignment;
                System.out.println("Math Test Grade: " 
                    + mathTest.getGrade());
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        List<Assignment> assignments = new ArrayList<>();
        assignments.add(new Essay("John", 45, 45));        // 90 total
        assignments.add(new MathTest("Alice", 9, 10));     // 90%
        
        GradeCalculator calculator = new GradeCalculator();
        calculator.processAssignments(assignments);
    }
}