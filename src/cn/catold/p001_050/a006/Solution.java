package cn.catold.p001_050.a006;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/zigzag-conversion/?tab=Description
 * <p>
 *
 */
public class Solution extends BaseSolution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        StringBuilder pre = new StringBuilder();
        StringBuilder[] mid = new StringBuilder[numRows - 2];
        StringBuilder aft = new StringBuilder();
        int divider = (numRows - 1) * 2;
        for (int i = 0; i < s.length(); i++) {
            int mod = i % divider;
            /*
            * divider的倍数存在pre中,同时可以判断最后的一组数
            * 中间的建立n - 2个SB一次存多余的字符,index依据mod判断
            */

            if (mod == 0) {
                pre.append(s.charAt(i));
            } else if (mod == numRows - 1) {
                aft.append(s.charAt(i));
            } else {
                int index = mod < numRows - 1? mod - 1 : divider - mod - 1;
                if (mid[index] == null) {
                    mid[index] = new StringBuilder();
                }
                mid[index].append(s.charAt(i));
            }
        }

        for (int i = 0; i < mid.length; i++) {
            pre.append(mid[i]);
        }
        return pre.append(aft).toString();
    }

    @Override
    public Object run() {
        System.out.println(convert("12345", 4));
        return null;
    }
}
