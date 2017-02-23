package cn.catold.p001_050.a022;

import cn.catold.util.BaseSolution;
import cn.catold.util.ListNode;

import java.util.*;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack1(res, "", 0, 0, n);
        return res;
    }

    public void generate(int n, String pre, List<String> list) {
        if (n == 0) {
            list.add(pre);
            return;
        }

        String[] next = new String[]{"(" + pre + ")", pre + "()", "()" + pre};
        generate(n - 1, next[0], list);

        if (!next[0].equals(next[1])) {
            generate(n - 1, next[1], list);
        }

        if (!next[2].equals(next[1]) && !next[2].equals(next[0])) {
            generate(n - 1, next[2], list);
        }
    }

    public void backtrack1(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack1(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack1(list, str + ")", open, close + 1, max);
    }


    @Override
    public Object run() {
        System.out.println(generateParenthesis(3));
        return null;
    }
}
