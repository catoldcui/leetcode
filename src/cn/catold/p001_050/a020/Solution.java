package cn.catold.p001_050.a020;

import cn.catold.util.BaseSolution;
import cn.catold.util.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public static final List<Character> BACK = Arrays.asList(']', '}', ')');
    public static final List<Character> FRONT = Arrays.asList('[', '{', '(');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (BACK.contains(c)) {
                if (stack.empty()) {
                    return false;
                }

                if (FRONT.indexOf(stack.pop()) != BACK.indexOf(c)) {
                    return false;
                }
            } else {
                stack.push(c);

                if (stack.size() > s.length() - i) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    @Override
    public Object run() {
//        Object o = threeSum(new int[]{0, 0, 0, 0});
//        System.out.println(removeNthFromEnd());
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{{{{})}"));
        return null;
    }
}
