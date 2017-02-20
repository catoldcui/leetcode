package cn.catold.p001_050.a005;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring
 * <p>
 * 每次判断是否可产生比curLength长的回文串.
 */
public class Solution extends BaseSolution {
    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLength - 1, i)) {
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) return false;
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }

    // dp(i, j) represents whether s(i ... j) can form a palindromic substring, dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring. When we found a palindrome, check if it's the longest one. Time complexity O(n^2).


    public String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        String ret = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = (s.charAt(i) == s.charAt(j)) && (i - j < 3 || dp[j + 1][i - 1]);
                // System.out.println(ret);
                if (dp[j][i] && (i - j + 1) > ret.length()) {
                    ret = s.substring(j, i + 1);
                }
            }
        }
        return ret;
    }

    @Override
    public Object run() {
        System.out.println(longestPalindrome1(""));
        return null;
    }
}
