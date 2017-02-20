package cn.catold.p001_050.a008;

import cn.catold.util.BaseSolution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/reverse-integer/?tab=Description
 * <p>
 */
public class Solution extends BaseSolution {
    public int myAtoi(String str) {
        if ("".equals(str) || str == null) {
            return 0;
        }
        int res = 0;
        int i = 0, sign = 1;

        str = str.trim();
        if (str.startsWith("-")) {
            i = 1;
            sign = -1;
        } else if (str.startsWith("+")) {
            i = 1;
        }

        int after = res;
        for (; i < str.length(); i++) {
            int minus = str.charAt(i) - '0';
            if (minus < 0 || minus > 9) {
                break;
            }
            after = res * 10 + minus;
            if (after / 10 != res) {
                break;
            }
            res = after;
        }

        res = sign * res;
        if (res != after * sign) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return res;
    }

    public int myAtoi1(String str) {
        int length = str.length();
        int ret = 0;
        boolean negative = false;
        int i = 0;
        while (i < length && str.charAt(i) == ' ') i++;
        if (i < length && str.charAt(i) == '-') {
            negative = true;
            i++;
        } else if (i < length && str.charAt(i) == '+') i++;
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c > '9' || c < '0') break;
            if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ret = ret * 10 + c - '0';
        }
        return negative ? -ret : ret;
    }

    @Override
    public Object run() {
        System.out.println(myAtoi1("123"));
        return null;
    }
}
