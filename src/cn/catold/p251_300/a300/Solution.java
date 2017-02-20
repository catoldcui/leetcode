package cn.catold.p251_300.a300;

import cn.catold.util.BaseSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/nim-game/
 */
public class Solution extends BaseSolution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] d = new int[nums.length];
        Arrays.fill(d, 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 1;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(d[j] + 1, max);
                }
            }
            d[i] = max;
        }

        int max = 0;
        for (int num : d) {
            max = Math.max(num, max);
        }
        return max;
    }

    public int lengthOfLIS1(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (dp.size() == 0 || dp.get(dp.size() - 1) < num) dp.add(num);
            else {
                int i = Collections.binarySearch(dp, num);
                dp.set((i < 0) ? -i - 1 : i, num);
            }
        }
        return dp.size();
    }

    @Override
    public Object run() {
        System.out.println(lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        return null;
    }
}
