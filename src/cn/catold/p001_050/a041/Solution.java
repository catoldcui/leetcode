package cn.catold.p001_050.a041;

import cn.catold.util.BaseSolution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
    public int firstMissingPositive(int[] nums) {
        boolean[] board = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                board[nums[i]] = true;
            }
        }

        int i = 1;
        for (; i < board.length; i++) {
            if (!board[i]) {
                break;
            }
        }
        return i;
    }

    public int firstMissingPositive1(int[] nums) {

        int i = 0, n = nums.length;
        while (i < n) {
            // If the current value is in the range of (0,length) and it's not at its correct position,
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }
        int k = 1;

        // Check from k=1 to see whether each index and value can be corresponding.
        while (k < n && nums[k] == k)
            k++;

        // If it breaks because of empty array or reaching the end. K must be the first missing number.
        if (n == 0 || k < n)
            return k;
        else   // If k is hiding at position 0, K+1 is the number.
            return nums[0] == k ? k + 1 : k;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    @Override
    public Object run() {
        System.out.println(firstMissingPositive(new int[]{1, 1}));
        System.out.println(firstMissingPositive(new int[]{2}));
        System.out.println(firstMissingPositive(new int[]{3}));
        System.out.println(firstMissingPositive(new int[]{1, 1000}));
        return null;
    }
}
