package StackInfix;

public class PostfixEvaluator {

    public static int evaluate(String postfixExpr) {
        CharStack stack = new CharStack();
        int length = postfixExpr.length();
        int i = 0;

        while (i < length) {
            char symbol = postfixExpr.charAt(i);

            // Skip spaces
            if (symbol == ' ') {
                i++;
                continue;
            }

            // Read numeric token
            if (Character.isDigit(symbol)) {
                String numStr = "";
                while (i < length && Character.isDigit(postfixExpr.charAt(i))) {
                    numStr = numStr + postfixExpr.charAt(i);
                    i++;
                }
                stack.push(numStr);
                continue;
            } 
            // Calculate when encountering an operator
            else {
                int rightOperand = Integer.parseInt(stack.pop());
                int leftOperand = Integer.parseInt(stack.pop());
                int calculation = 0;

                switch (symbol) {
                    case '+': calculation = leftOperand + rightOperand; break;
                    case '-': calculation = leftOperand - rightOperand; break;
                    case '*': calculation = leftOperand * rightOperand; break;
                    case '/': calculation = leftOperand / rightOperand; break;
                    case '^': calculation = (int) Math.pow(leftOperand, rightOperand); break;
                }
                stack.push(String.valueOf(calculation));
            }
            i++;
        }

        return Integer.parseInt(stack.pop());
    }
}