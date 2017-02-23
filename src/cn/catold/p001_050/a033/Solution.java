package cn.catold.p001_050.a033;

import cn.catold.util.BaseSolution;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = end / 2;
        while (start < end) {
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[start]) {
                if(target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {
                if (target < nums[start] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
            mid = start + (end - start) / 2;
        }

        return nums[mid] != target? -1 : mid;
    }


    @Override
    public Object run() {
        System.out.println(search(new int[]{4,5,6,7,0,1,2,3}, 2));
        return null;
    }
}
