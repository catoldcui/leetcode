package cn.catold.p001_050.a026;

import cn.catold.util.BaseSolution;
import cn.catold.util.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[cur]) {
                cur++;
                nums[cur] = nums[i];
            }
        }
        return cur + 1;
    }


    @Override
    public Object run() {

        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        return null;
    }
}
