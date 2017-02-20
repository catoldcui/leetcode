package cn.catold.p251_300.a284;

import cn.catold.util.BaseSolution;

import java.util.Arrays;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/peeking-iterator/
 */
public class Solution extends BaseSolution {
    public void moveZeroes(int[] nums) {
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] != 0) {
//                nums[index] = nums[i];
//                index++;
//            }
//        }
//        for(; index < nums.length; index++) {
//            nums[index] = 0;
//        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
//        int count0 = 0;
//        for (int i = 0; i < nums.length - count0; i++) {
//            if (nums[i] == 0) {
//                for(int j = i + 1; j < nums.length - count0; j++) {
//                    if (nums[j] != 0) {
//                        nums[i] = nums[j];
//                        nums[j] = 0;
//                        i++;
//                    }
//                }
//                count0++;
//            }
//        }

    }


    @Override
    public Object run() {
        int[] a = new int[]{0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));

        return null;
    }
}
