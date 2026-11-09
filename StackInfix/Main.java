package StackInfix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("     INFIX EXPRESSION PROCESSOR       ");
        System.out.println("======================================");

        System.out.print("Enter Infix Expression (e.g., 6 - (2 + 3) * 3): ");
        String infixExpression = inputScanner.nextLine();

        // Step 1: Process Conversion to String Postfix
        String postfixExpression = InfixConverter.toPostfix(infixExpression);
        System.out.println("\nGenerated Postfix Expression : " + postfixExpression);

        // Step 2: Process Evaluation using String Postfix
        int result = PostfixEvaluator.evaluate(postfixExpression);
        System.out.println("Evaluation Result            : " + result);

        inputScanner.close();
    }
}