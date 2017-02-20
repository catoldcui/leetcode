package cn.catold.p251_300.a287;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class Solution extends BaseSolution {
//    public int findDuplicate(int[] nums) {
//        int slow = 0;
//        int fast = 0;
//        do {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        } while (nums[slow] != nums[fast]);
//
//        slow = 0;
//        while (nums[slow] != nums[fast]) {
//            slow = nums[slow];
//            fast = nums[fast];
//        }
//
//        return nums[slow];
//    }

    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    @Override
    public Object run() {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 1, 2}));

        return null;
    }
}
