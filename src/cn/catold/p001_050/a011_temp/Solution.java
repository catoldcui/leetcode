package cn.catold.p001_050.a011_temp;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/reverse-integer/?tab=Description
 * <p>
 */
public class Solution extends BaseSolution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = 1;
        int minHeight = Math.min(height[i], height[j]);
        max = Math.max(minHeight * (j - i), max);
        while (i < height.length - 1) {
            minHeight = Math.min(height[i], height[j]);
            while (j + 1 < height.length && height[j + 1] >= height[i + 1]) {
                j++;
            }
            max = Math.max(minHeight * (j - i), max);

            if (j == height.length - 1) {
                int cur = i;
                while(++i < height.length && height[i] <= height[cur]);
                j = i + 1;
            } else {
                j++;
            }
        }

        return max;
    }


    @Override
    public Object run() {
        System.out.println(maxArea(new int[]{3,2,1,3}));
        return null;
    }
}
