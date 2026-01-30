import java.util.Stack;

class BracketChecker {

    private final String brackets;

    BracketChecker(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        brackets = expression.replaceAll("[^\\[\\]\\(\\)\\{\\}]", "");
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> stack = new Stack<>();
        for (char c : brackets.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isBracketPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isBracketPair(char left, char right) {
        return left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}';
    }

}