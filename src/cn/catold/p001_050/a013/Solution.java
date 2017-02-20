package cn.catold.p001_050.a013;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/reverse-integer/?tab=Description
 * <p>
 */
public class Solution extends BaseSolution {
    public int romanToInt(String s) {
        int result = 0;
        char pre = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = 0;
            switch (s.charAt(i)) {
                case 'M':
                    if (pre != 'C') {
                        v = 1000;
                    } else {
                        v = 800;
                    }
                    break;
                case 'D':
                    if (pre != 'C') {
                        v = 500;
                    } else {
                        v = 300;
                    }
                    break;
                case 'C':
                    if (pre != 'X') {
                        v = 100;
                    } else {
                        v = 80;
                    }
                    break;
                case 'L':
                    if (pre != 'X') {
                        v = 50;
                    } else {
                        v = 30;
                    }
                    break;
                case 'X':
                    if (pre != 'I') {
                        v = 10;
                    } else {
                        v = 8;
                    }
                    break;
                case 'V':
                    if (pre != 'I') {
                        v = 5;
                    } else {
                        v = 3;
                    }
                    break;
                case 'I':
                    v = 1;
            }
            pre = s.charAt(i);
            result += v;
        }

        return result;
    }


    @Override
    public Object run() {
        System.out.println(romanToInt("MCMXCVI"));
        return null;
    }
}
