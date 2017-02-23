package cn.catold.p001_050.a018;

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

    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }

            int temp = target - nums[i];

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {              // skip same result
                    continue;
                }
                int n = j + 1;
                int m = nums.length - 1;
                int temp1 = temp;
                temp1 -= nums[j];

                while (n < m) {
                    if (nums[n] + nums[m] == temp1) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[n], nums[m]));
                        n++;
                        m--;
                        while (n < m && nums[n] == nums[n - 1]) n++;  // skip same result
                        while (n < m && nums[m] == nums[m + 1]) m--;  // skip same result
                    } else if (nums[n] + nums[m] > temp1) {
                        m--;
                    } else {
                        n++;
                    }
                }
            }

        }
        return res;
    }


    @Override
    public Object run() {
//        Object o = threeSum(new int[]{0, 0, 0, 0});
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));

        return null;
    }
}
