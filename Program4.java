import java.util.*;

class Prefix {
    static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    static int getPriority(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }

    // Reverse the string
    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Convert infix to postfix
    static String infixToPostfix(String infix) {
        MyStack<Character> stack = new MyStack<>(infix.length());
        StringBuilder output = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (isOperand(c)) { // If operand, add to output
                output.append(c);
            } else if (c == '(') { // Push '(' to stack
                stack.push(c);
            } else if (c == ')') { // Pop until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } else { // Operator case
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    // Convert infix to prefix
    static String infixToPrefix(String infix) {
        // Reverse the infix expression
        infix = reverse(infix);

        // Replace '(' with ')' and vice versa
        char[] arr = infix.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') arr[i] = ')';
            else if (arr[i] == ')') arr[i] = '(';
        }

        // Convert to postfix
        String postfix = infixToPostfix(new String(arr));

        // Reverse the postfix to get prefix
        return reverse(postfix);
    }
}
public class Program4{
    public static void main(String[] args) {
        String infix = "(p+q)*(c-d)";
        System.out.println("Infix expression: " + infix);
        System.out.println("Prefix expression: " + Prefix.infixToPrefix(infix));
    }
}
