package cn.catold.p251_300.a295;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class Solution extends BaseSolution {

    @Override
    public Object run() {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(1);
        obj.addNum(4);
        System.out.println(obj.findMedian());
        return null;
    }
}
