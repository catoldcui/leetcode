package cn.catold.p251_300.a279;

import cn.catold.util.BaseSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/perfect-squares/
 */
public class Solution extends BaseSolution {
    public final Map map = new HashMap<>();

    public final int globalMin = Integer.MAX_VALUE;

    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        return D(n);
    }

    public int D(int n) {

//        if (map.containsKey(n)) {
//            return (Integer) map.get(n);
//        }
//
//        int maxPow = (int) Math.sqrt(n);
//        int min = Integer.MAX_VALUE;
//        for (int pow = maxPow; pow >= 1; pow--) {
//            int pow2 = pow * pow;
//            if (n == pow2) {
//                return 1;
//            }
//            min = Math.min(min, D(n - pow2) + 1);
//        }
//
//        map.put(n, min);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }


    @Override
    public Object run() {
        System.out.println(numSquares(234532));

        return null;
    }
}
