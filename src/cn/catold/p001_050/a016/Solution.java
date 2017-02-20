package cn.catold.p001_050.a016;

import cn.catold.util.BaseSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public int threeSumClosest(int[] nums, int target) {
        int less = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;
            int temp = target;
            temp -= nums[i];
            while (j < k) {
                int cur = temp - nums[j] - nums[k];

                if (Math.abs(cur) < Math.abs(less)) {
                    less = cur;
                }

                if (cur > 0) {
                    j++;
                    while (nums[j - 1] == nums[j] && j < k) j++;
                } else if(cur < 0) {
                    k--;
                    while (nums[k] == nums[k + 1] && j < k) k--;
                } else {
                    return target;
                }
            }
        }
        return target - less;
    }


    @Override
    public Object run() {
        System.out.println(threeSumClosest(new int[]{1, 2, 3, 1, -3, -4, -1, 1, -1, 0, 0, 0}, 5));
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 0));
        System.out.println(threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));

        return null;
    }
}
