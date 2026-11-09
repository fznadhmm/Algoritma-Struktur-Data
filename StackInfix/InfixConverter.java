package StackInfix;

public class InfixConverter {

    // Helper method for operator precedence
    private static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    public static String toPostfix(String inputExpr) {
        CharStack stack = new CharStack();
        String postfixResult = "";
        int length = inputExpr.length();
        int i = 0;

        while (i < length) {
            char symbol = inputExpr.charAt(i);

            // Skip spaces
            if (symbol == ' ') {
                i++;
                continue;
            }

            // If symbol is a digit number
            if (Character.isDigit(symbol)) {
                String numberBuffer = "";
                while (i < length && Character.isDigit(inputExpr.charAt(i))) {
                    numberBuffer = numberBuffer + inputExpr.charAt(i);
                    i++;
                }
                postfixResult = postfixResult + numberBuffer + " ";
                continue;
            } 
            // If symbol is opening parenthesis '('
            else if (symbol == '(') {
                stack.push(String.valueOf(symbol));
            } 
            // If symbol is closing parenthesis ')'
            else if (symbol == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfixResult = postfixResult + stack.pop() + " ";
                }
                stack.pop(); // Pop '('
            } 
            // If symbol is an operator
            else {
                while (!stack.isEmpty() && getPrecedence(stack.peek().charAt(0)) >= getPrecedence(symbol)) {
                    postfixResult = postfixResult + stack.pop() + " ";
                }
                stack.push(String.valueOf(symbol));
            }
            i++;
        }

        // Pop all remaining operators
        while (!stack.isEmpty()) {
            postfixResult = postfixResult + stack.pop() + " ";
        }

        return postfixResult.trim();
    }
}