package cn.catold.p001_050.a007;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/reverse-integer/?tab=Description
 * <p>
 *
 */
public class Solution extends BaseSolution {
    public int reverse(int x) {
        String temp = String.valueOf(Math.abs(x));
        try {
            int res = Integer.parseInt(new StringBuilder(temp).reverse().toString());
            if (x < 0) {
                return -res;
            } else {
                return res;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse1(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    @Override
    public Object run() {
        System.out.println(reverse(-32552));
        return null;
    }
}
