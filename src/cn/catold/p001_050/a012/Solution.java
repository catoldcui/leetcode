package cn.catold.p001_050.a012;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/reverse-integer/?tab=Description
 * <p>
 */
public class Solution extends BaseSolution {
    public static final String[][] num0 = new String[][]{
            new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            new String[]{"", "M", "MM", "MMM"}
    };
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            sb.insert(0, num0[i][num % 10]);

            num /= 10;
            i++;
        }

        return sb.toString();
    }


    @Override
    public Object run() {
        System.out.println(intToRoman(11));
        return null;
    }
}
