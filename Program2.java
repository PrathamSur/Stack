//2. Write a method in a separate class to check an expression is valid or not.
class CheckValid{
    public static boolean isValidExpression(String expr) {
        MyStack<Character> stack = new MyStack<>(expr.length());

        // Mapping of closing brackets to opening brackets
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false; // No matching opening bracket
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) return false;
            }
        }

        return stack.isEmpty(); // If stack is empty, expression is valid
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
public class Program2 {
    public static void main(String[] args) {
        System.out.println(CheckValid.isValidExpression("(a+b)"));
    }
}
