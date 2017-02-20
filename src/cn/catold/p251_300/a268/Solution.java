package cn.catold.p251_300.a268;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/missing-number/
 */
public class Solution extends BaseSolution {
    public int missingNumber(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//
//        int delta = (nums.length + 1) * nums.length / 2;
//        return delta - sum;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result ^ nums.length;
    }

    @Override
    public Object run() {
        System.out.println(missingNumber(new int[]{0, 1, 3}));

        return null;
    }
}
