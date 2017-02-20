package cn.catold.p251_300.a275;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/h-index-ii/
 *
 */
public class Solution extends BaseSolution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = len - 1;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (citations[mid] >= len - mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return len - start;
    }

    @Override
    public Object run() {
        System.out.println(hIndex(new int[]{0}));

        return null;
    }
}
