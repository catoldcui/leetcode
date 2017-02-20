package cn.catold.p001_050.a009;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/reverse-integer/?tab=Description
 * <p>
 */
public class Solution extends BaseSolution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0, e = str.length() - 1;
        while (i < e) {
            if (str.charAt(i) != str.charAt(e)) {
                return false;
            }
            i++;
            e--;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        int reverse = 0;
        int temp = x;
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == temp;
    }

    @Override
    public Object run() {
        System.out.println(isPalindrome1(2147483647));
        return null;
    }
}
