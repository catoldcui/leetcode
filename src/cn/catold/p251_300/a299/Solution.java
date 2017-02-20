package cn.catold.p251_300.a299;

import cn.catold.util.BaseSolution;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/nim-game/
 */
public class Solution extends BaseSolution {
    public String getHint(String secret, String guess) {
//        HashSet<Integer>[] sets = new HashSet[10];
//        int[] count = new int[10];
//        for (int i = 0; i < secret.length(); i++) {
//            int index = secret.charAt(i) - '0';
//            if (sets[index] == null) {
//                sets[index] = new HashSet<>();
//            }
//            sets[index].add(i);
//            count[index] += 1;
//        }
//
//        int correct = 0;
//        int wrong = 0;
//        for (int i = 0; i < guess.length(); i++) {
//            int index = guess.charAt(i) - '0';
//            if (sets[index] == null) {
//                continue;
//            }
//
//            count[index]--;
//
//            if (sets[index].contains(i)) {
//                correct++;
//                sets[index].remove(i);
//            } else {
//                if (count[index] >= 0) {
//                    wrong++;
//                }
//            }
//        }
//
//        return correct + "A" + wrong + "B";

        int[] cnt = new int[10]; //Count the digits in secret
        for (char c : secret.toCharArray()) {
            cnt[c - '0']++;
        }
        int j = 0, bulls = 0, cows = 0;
        for (char c : guess.toCharArray()) {
            int ind = c - '0';
            if (secret.charAt(j) == c) {
                bulls++;
                cnt[ind]--;
                //if cnt <0 we double counted cows so decrement by 1
                if (cnt[ind] < 0) cows--;
            } else if (cnt[ind] > 0) {
                cows++;
                cnt[ind]--;
            }
            j++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
    }

    @Override
    public Object run() {
        System.out.println(getHint("1807", "7810"));
        return null;
    }
}
