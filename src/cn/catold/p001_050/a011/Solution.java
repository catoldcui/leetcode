package cn.catold.p001_050.a011;

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
            while (j + 1 < height.length && height[j + 1] >= height[j]) {
                j++;
            }
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);

            if (j == height.length - 1) {
                int cur = i;
                while (++i < height.length && height[i] <= height[cur]) ;
                j = i + 1;
            } else {
                j++;
            }
        }

        return max;
    }

    public int maxArea1(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int loMax = height[i];
            int hiMax = height[j];
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);

            // 重点
            if (height[i] <= height[j]) {
                while (i < j && height[i] <= loMax) ++i;
            } else {
                while (i < j && height[j] <= hiMax) --j;
            }
        }

        return max;
    }


    @Override
    public Object run() {
        System.out.println(maxArea1(new int[]{5, 2, 12, 1, 5, 3, 4, 11, 9, 4}));
        System.out.println(maxArea1(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
        return null;
    }
}
