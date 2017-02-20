package cn.catold.p151_200.a152;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class Solution extends BaseSolution {
    public int maxProduct(int[] nums) {
        int totalMax = Integer.MIN_VALUE, max = 1, min = 1;

        for (int num : nums) {
            int maxN, minN;
            maxN = Math.max(Math.max(max * num, min * num), num);
            minN = Math.min(Math.min(max * num, min * num), num);
            max = maxN;
            min = minN;
            if (max > totalMax) {
                totalMax = max;
            }
        }
        return totalMax;
    }

    @Override
    public Object run() {
        System.out.println(maxProduct(new int[]{-4, -3, -2}));

        return null;
    }
}
