package cn.catold.p251_300.a282;

import cn.catold.util.BaseSolution;

import java.util.*;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/perfect-squares/
 */
public class Solution extends BaseSolution {
    public List<String> addOperators(String num, int target) {
        char[] digit = num.toCharArray(), path = new char[num.length() * 2];
        List<String> ans = new ArrayList();
        long pureNum = 0;
        for (int i = 0; i < digit.length; i++) {
            pureNum = pureNum * 10 + (long)(digit[i] - '0');
            path[i] = digit[i];
            dfs(i + 1, i + 1, 0, pureNum, path, digit, target, ans);
            if (pureNum == 0) break; // not allow number with 0 prefix, except zero itself;
        }
        return ans;
    }

    private void dfs(int ip, int id, long toAdd, long toMult, char[] path, char[] digit, int target, List<String> ans) {
        if (id == digit.length && toAdd + toMult == target) {
            ans.add(String.valueOf(path, 0, ip));
            return;
        }
        long pureNum = 0;
        for (int i = 0; id + i < digit.length; i++) {
            pureNum = pureNum * 10 + (long)(digit[id + i] - '0');
            path[ip + i + 1] = digit[id + i];
            path[ip] = '+';
            dfs(ip + i + 2, id + i + 1, toAdd + toMult, pureNum, path, digit, target, ans);
            path[ip] = '-';
            dfs(ip + i + 2, id + i + 1, toAdd + toMult, -pureNum, path, digit, target, ans);
            path[ip] = '*';
            dfs(ip + i + 2, id + i + 1, toAdd, toMult * pureNum, path, digit, target, ans);
            if (pureNum == 0) break; // not allow number with 0 prefix, except zero itself;
        }
    }


//    public List<String> addOperators(String num, int target) {
//        List<String> res = new ArrayList<>();
//
//        if ("".equals(num)) {
//            return res;
//        }
//
//        helper(res, num, "", 0, 0, 0, target);
//        return res;
//    }

    /**
     * @param res    符合要求的结果string集合
     * @param num    参数
     * @param path   之前的代数式
     * @param pos    当前未计算位置
     * @param eval   剩余的值
     * @param multed 如果是乘号,需知道前一个的值(带符号).
     * @param target 目标值
     */
    public void helper(List<String> res, String num, String path, int pos, long eval, long multed, long target) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }

        for (int i = pos + 1; i <= num.length(); i++) {
            String subStr = num.subSequence(pos, i).toString();

            if(subStr.length() > 1 && subStr.startsWith("0")) {
                break;
            }

            long cur = Long.parseLong(subStr);
            if ("".equals(path)) {
                helper(res, num, path + cur, i, eval + cur, cur, target);
            } else {
                helper(res, num, path + "+" + cur, i, eval + cur, cur, target);
                helper(res, num, path + "-" + cur, i, eval - cur, -cur, target);
                helper(res, num, path + "*" + cur, i, eval - multed + multed * cur, multed * cur, target);
            }
        }
    }


    @Override
    public Object run() {
        System.out.println(addOperators("103", 4));

        return null;
    }
}
