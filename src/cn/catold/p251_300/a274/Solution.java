package cn.catold.p251_300.a274;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/h-index/
 * 桶排序
 * step1: 建立一个length+1长的数组,第i个表示引用大于等于长度i的文献有几个.
 * step2: 反向一次求和,直至引用总和大于长度i
 */
public class Solution extends BaseSolution {
    public int hIndex(int[] citations) {
        int L = citations.length;
        if (L < 1) return 0;
        int[] counts = new int[L + 1];
        for (int i : citations) {
            if (i > L) counts[L]++;
            else counts[i]++;
        }
        int res = 0;
        for (int k = L; k >= 0; k--) {
            res += counts[k];
            if (res >= k) return k;
        }
        return 0;
    }

    @Override
    public Object run() {
        System.out.println(hIndex(new int[]{1, 1, 3}));

        return null;
    }
}
