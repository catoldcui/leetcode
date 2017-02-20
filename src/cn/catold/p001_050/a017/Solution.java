package cn.catold.p001_050.a017;

import cn.catold.util.BaseSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public static final char[][] board = new char[][]{
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'},
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if ("".equals(digits)) {
            return res;
        }

        backtracking(digits, res, "");
        return res;
    }

    public void backtracking(String digits, List<String> res, String preStr) {
        if (digits.length() == preStr.length()) {
            res.add(preStr);
            return;
        }

        for (int i = 0; i < board[digits.charAt(preStr.length()) - '2'].length; i++) {
            backtracking(digits, res, preStr + board[digits.charAt(preStr.length()) - '2'][i]);
        }
    }

    @Override
    public Object run() {
        System.out.println(letterCombinations("254"));

        return null;
    }
}
