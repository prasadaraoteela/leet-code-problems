import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Prasada Rao on 11/10/21 3:55 PM
 *
 * <a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a>
 **/
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.isEmpty()) return true;

        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                characters.push(c);
                continue;
            }
            if (characters.isEmpty()) return false;

            Character peek = characters.pop();
            switch (c) {
                case ')' -> {
                    if (peek != '(') return false;
                }
                case '}' -> {
                    if (peek != '{') return false;
                }
                case ']' -> {
                    if (peek != '[') return false;
                }
            }
        }
        return characters.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s.isEmpty()) return true;

        final HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> characters = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                characters.push(c);
            } else {
                if (characters.isEmpty() || c != map.get(characters.pop())) {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    public boolean isValid1(String s) {
        if (s.isEmpty()) return true;

        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                characters.push(s.charAt(i));
            } else {
                if (characters.isEmpty()) return false;
                Character last = characters.pop();
                if (s.charAt(i) == ')' && last != '(') return false;
                if (s.charAt(i) == '}' && last != '{') return false;
                if (s.charAt(i) == ']' && last != '[') return false;
            }
        }
        return characters.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("() " + new ValidParentheses().isValid("()"));
        System.out.println("()[]{} " + new ValidParentheses().isValid("()[]{}"));
        System.out.println("(] " + new ValidParentheses().isValid("(]"));
        System.out.println("([)] " + new ValidParentheses().isValid("([)]"));
        System.out.println("{[]} " + new ValidParentheses().isValid("{[]}"));
        System.out.println("] " + new ValidParentheses().isValid("]"));
    }
}
