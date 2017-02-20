package cn.catold.p001_050.a014;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/reverse-integer/?tab=Description
 * <p>
 */
public class Solution extends BaseSolution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int i = 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < strs.length; j++) {
            min = Math.min(strs[j].length(), min);
        }

        boolean res = false;
        while (i < min) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != cur) {
                    res = true;
                    break;
                }
            }
            if (res) {
                break;
            }
            i++;
        }
        return strs[0].substring(0, Math.min(i, min));
    }


    @Override
    public Object run() {
        System.out.println(longestCommonPrefix(new String[]{"abc","abc","abc"}));
        System.out.println(longestCommonPrefix(new String[]{"a","b"}));
        System.out.println(longestCommonPrefix(new String[]{"aa","ab"}));
        return null;
    }
}
