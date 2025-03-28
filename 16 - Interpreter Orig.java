class SimpleCalculator {
    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        
        if (tokens.length == 3) {
            int num1 = Integer.parseInt(tokens[0]);
            String operator = tokens[1];
            int num2 = Integer.parseInt(tokens[2]);
            
            if (operator.equals("+")) {
                return num1 + num2;
            } else if (operator.equals("-")) {
                return num1 - num2;
            }
        }
        throw new RuntimeException("Invalid expression");
    }
}

class Main {
    public static void main(String[] args) {
        // Before - Using simple calculator
        SimpleCalculator calculator = new SimpleCalculator();
        System.out.println("Before - Result: " + 
            calculator.evaluate("5 + 3")); // Output: 8       
    }
}