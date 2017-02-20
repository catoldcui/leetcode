package cn.catold.p501_550.a526;

import cn.catold.util.BaseSolution;

import java.util.Arrays;

/**
 * Created by catold on 20/01/2017.
 * <p>
 */
public class Solution extends BaseSolution {
    public int countArrangement(int N) {
        boolean[][] b = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                b[i][j] = true;
                b[j][i] = true;
            }
        }
        return backtrack(new boolean[N + 1], 1, b);
    }

    public int backtrack(boolean[] used, int curIndex, boolean[][] b) {
        if (curIndex == used.length) return 1;
        int sum = 0;
        for (int i = 1; i < used.length; i++) {
            if (!used[i] && (b[i][curIndex] || b[curIndex][i])) {
                used[i] = true;
                sum += backtrack(used, curIndex + 1, b);
                used[i] = false;
            }
        }
        return sum;
    }


    @Override
    public Object run() {
        System.out.println(countArrangement(3));
        System.out.println(countArrangement(4));
        System.out.println(countArrangement(5));
        System.out.println(countArrangement(6));
        System.out.println(countArrangement(7));
        System.out.println(countArrangement(8));
        System.out.println(countArrangement(9));
        System.out.println(countArrangement(10));
        return null;
    }
}
