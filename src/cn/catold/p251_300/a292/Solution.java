package cn.catold.p251_300.a292;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/nim-game/
 */
public class Solution extends BaseSolution {
    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }

    @Override
    public Object run() {
        System.out.println(canWinNim(13));
        return null;
    }
}
