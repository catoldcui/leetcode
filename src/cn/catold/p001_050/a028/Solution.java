package cn.catold.p001_050.a028;

import cn.catold.util.BaseSolution;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public int strStr(String haystack, String needle) {
        int[] overlay = new int[needle.length()];

        overlay[0] = -1;
        for (int i = 1; i < needle.length(); i++) {
            int index = overlay[i - 1];
            while(index >= 0 && needle.charAt(index + 1) != needle.charAt(i)){
                index = overlay[index];
            }

            if (needle.charAt(index + 1) != needle.charAt(i)) {
                overlay[i] = -1;
            } else {
                overlay[i] = index + 1;
            }
        }
        return 1;
    }


    @Override
    public Object run() {

        System.out.println(strStr("test", "abaabcaba"));
        return null;
    }
}
