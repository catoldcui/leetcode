package cn.catold.p001_050.a015;

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
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        int length = nums.length * (nums.length - 1) / 2;
        int[] d = new int[length];
        int[] iMap = new int[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            iMap[i] = iMap[i - 1] + nums.length - i;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            for (; j < nums.length - 1; j++) {
                int index = iMap[i] + j - i - 1;
                d[index] = nums[i] + nums[j];

                if (d[index] > 0) {
                    break;
                }
            }
        }


        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int k = nums.length - 1;
            int j = i + 1;

            int pre = d[iMap[i] + j - i - 1] - 1;
            for (; j < nums.length - 1; j++) {
                int index = iMap[i] + j - i - 1;
                if (d[index] > 0) {
                    break;
                }

                if (d[index] == pre) {
                    continue;
                }
                pre = d[index];

                for (; k >= j + 1; k--) {
                    int sum = d[index] + nums[k];
                    if (sum < 0) {
                        break;
                    }

                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);

                        break;
                    }
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }


    @Override
    public Object run() {
//        Object o = threeSum(new int[]{0, 0, 0, 0});
        Object o1 = threeSum(new int[]{1,2,3,1,-3,-4,-1,1,-1,0,0,0});

        return null;
    }
}
