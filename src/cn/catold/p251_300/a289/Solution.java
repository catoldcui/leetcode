package cn.catold.p251_300.a289;

import cn.catold.util.BaseSolution;

import java.util.Arrays;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/game-of-life/
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

    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m == 0) {
            return;
        }
        int n = board[0].length;

        int[][] temp = new int[m + 2][n + 2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i - 1][j - 1] != 0) {
                    temp[i - 1][j - 1]++;
                    temp[i - 1][j]++;
                    temp[i - 1][j + 1]++;
                    temp[i][j - 1]++;
                    temp[i][j + 1]++;
                    temp[i + 1][j - 1]++;
                    temp[i + 1][j]++;
                    temp[i + 1][j + 1]++;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                switch (temp[i][j]) {
                    case 2:
                        break;
                    case 3:
                        board[i - 1][j - 1] = 1;
                        break;
                    default:
                        board[i - 1][j - 1] = 0;
                }
            }
        }
    }

    @Override
    public Object run() {
        int[][] board = {new int[]{1, 1, 1}, new int[]{0, 0, 0}};
        gameOfLife(board);
        Arrays.toString(board);
        return null;
    }
}
