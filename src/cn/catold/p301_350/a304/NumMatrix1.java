package cn.catold.p301_350.a304;

/**
 * Created by catold on 17/02/2017.
 */
public class NumMatrix1 {
    int[][] sums;

    public NumMatrix1(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        this.sums = new int[matrix.length + 1][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sums[i + 1][j] = sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = col1; i <= col2; i++) {
            sum += sums[row2 + 1][i] - sums[row1][i];
        }
        return sum;
    }
}
