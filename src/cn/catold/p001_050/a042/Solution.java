package cn.catold.p001_050.a042;

import cn.catold.util.BaseSolution;

import java.util.Stack;

/**
 * <p>
 * <p>
 */
public class Solution extends BaseSolution {
//    public int trap(int[] height) {
//        Stack<Integer[]> stack = new Stack<>();
//
//        int sum = 0;
//        int preSum = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] == 0) {
//                continue;
//            }
//            if (stack.empty()) {
//                stack.push(new Integer[]{i, height[i]});
//                continue;
//            }
//
//            int curSum = 0;
//            int remove = 0;
//            while (!stack.empty() && height[i] >= stack.peek()[1]) {
//                Integer[] top = stack.pop();
//                curSum = height[i] * (i - top[0]) - remove;
//                remove += height[i];
//            }
//
//
//            preSum = curSum;
//            sum += curSum;
//        }
//    }


    @Override
    public Object run() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        return null;
    }
}
