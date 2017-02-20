package cn.catold.p301_350.a303;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/nim-game/
 */
public class Solution extends BaseSolution {

    @Override
    public Object run() {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(2, 5));
        return null;
    }
}
