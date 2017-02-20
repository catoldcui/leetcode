package cn.catold.p301_350.a301;

import cn.catold.util.BaseSolution;

import java.util.*;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/nim-game/
 */
public class Solution extends BaseSolution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }

    public List<String> removeInvalidParentheses1(String s) {
        List<String> res = new ArrayList<>();

        if ("".equals(s)) {
            res.add("");
            return res;
        }

        remove(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }

    public void remove(String s, List<String> res, int last_i, int last_j, char[] par) {
        for (int i = last_i, stack = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == par[0]) {
                stack++;
            } else if (c == par[1]) {
                stack--;
            }

            if (stack >= 0) {
                continue;
            }

            for(int j = last_j; j <= i; j++) {
                char cj = s.charAt(j);
                StringBuilder sb = new StringBuilder();
                if (cj == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(sb.append(s.substring(0, j)).append(s.substring(j + 1, s.length())).toString(), res, i, j, par);
                }
            }

            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, res, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }

    @Override
    public Object run() {
        System.out.println(removeInvalidParentheses1("())(())"));
        return null;
    }
}
