package easy;
import java.util.LinkedList;

public class ValidParantheses {

    public static boolean isValid(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            } else if (c == '{') {
                stack.push(c);
                continue;
            } else if (c == '[') {
                stack.push(c);
                continue;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
                continue;
            }else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
                continue;
            }else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
                continue;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.print(isValid(s));
    }
}
