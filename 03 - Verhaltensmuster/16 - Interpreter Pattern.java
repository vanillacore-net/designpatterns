// Step 1: Define the Expression interface
interface Expression {
    int interpret();
}

// Step 2: Terminal expressions (numbers)
class NumberExpression implements Expression {
    private int number;
    
    public NumberExpression(int number) {
        this.number = number;
    }
    
    @Override
    public int interpret() {
        return number;
    }
}

// Step 3: Non-terminal expressions (operations)
class AddExpression implements Expression {
    private Expression left;
    private Expression right;
    
    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class SubtractExpression implements Expression {
    private Expression left;
    private Expression right;
    
    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

// Step 4: Parser to create the expression tree
class ExpressionParser {
    public Expression parse(String expression) {
        String[] tokens = expression.split(" ");
        if (tokens.length != 3) {
            throw new RuntimeException("Invalid expression format");
        }
        
        Expression left = new NumberExpression(Integer.parseInt(tokens[0]));
        Expression right = new NumberExpression(Integer.parseInt(tokens[2]));
        
        switch (tokens[1]) {
            case "+":
                return new AddExpression(left, right);
            case "-":
                return new SubtractExpression(left, right);
            default:
                throw new RuntimeException("Unknown operator: " + tokens[1]);
        }
    }
}

// Usage example
class Main {
    public static void main(String[] args) {        
        // After - Using interpreter pattern
        ExpressionParser parser = new ExpressionParser();
        Expression expression1 = parser.parse("5 + 3");
        Expression expression2 = parser.parse("10 - 4");
        
        System.out.println("After - Result 1: " + 
            expression1.interpret()); // Output: 8
        System.out.println("After - Result 2: " + 
            expression2.interpret()); // Output: 6
    }
}


