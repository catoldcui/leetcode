package cn.catold.p001_050.a034;

import cn.catold.util.BaseSolution;

import java.util.Arrays;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return res;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = end / 2;
        while (start < end) {
            if (nums[mid] == target) {
                int s = mid;
                while(s > start && nums[s - 1] == target) s--;
                res[0] = s;
                s = mid;
                while(s < end && nums[s + 1] == target) s++;
                res[1] = s;
                return res;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }

        return nums[mid] != target? res : new int[]{mid, mid};
    }


    @Override
    public Object run() {
        System.out.println(Arrays.toString(searchRange(new int[]{1,1}, 1)));
        return null;
    }
}
