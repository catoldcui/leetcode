package cn.catold.p301_350.a304;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class Solution extends BaseSolution {


    @Override
    public Object run() {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = i * j;
            }
        }
        NumMatrix1 obj = new NumMatrix1(matrix);
        System.out.println(obj.sumRegion(2, 2, 3, 3));
        return null;
    }
}
