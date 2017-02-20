package cn.catold.p501_550.a520;

import cn.catold.util.BaseSolution;

import java.util.*;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/nim-game/
 */
public class Solution extends BaseSolution {
    public boolean detectCapitalUse(String word) {
        if ("".equals(word)) {
            return true;
        }

        boolean firstUp = word.charAt(0) < 'a';
        boolean upexist = false;
        boolean lowexist = false;
        for (int i = 1; i < word.length(); i++) {
            boolean isUp = word.charAt(i) < 'a';

            lowexist = lowexist || !isUp;
            upexist = upexist || isUp;
            if((!firstUp && upexist) || (firstUp && lowexist && upexist)){
                return false;
            }
        }

        return true;
    }
    @Override
    public Object run() {
        System.out.println(detectCapitalUse("Usa"));
        System.out.println(detectCapitalUse("UUa"));
        System.out.println(detectCapitalUse("asUdfa"));
        return null;
    }
}
