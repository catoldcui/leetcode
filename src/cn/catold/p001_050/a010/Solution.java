package cn.catold.p001_050.a010;

import cn.catold.util.BaseSolution;

import java.util.Arrays;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/reverse-integer/?tab=Description
 * <p>
 */
public class Solution extends BaseSolution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        // count(a)=0
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        /*
                        * dp[i + 1][j]: count(a) = 1
                        * dp[i][j + 1]: count(a) > 1
                        * dp[i + 1][j - 1]: count(a) = 0
                        */
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    @Override
    public Object run() {
        System.out.println(isMatch("aab", "c*a*b"));
        return null;
    }
}
