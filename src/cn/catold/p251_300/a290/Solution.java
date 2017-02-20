package cn.catold.p251_300.a290;

import cn.catold.util.BaseSolution;

import java.util.*;

/**
 * Created by catold on 20/01/2017.
 * <p>
 * https://leetcode.com/problems/word-pattern/
 */
public class Solution extends BaseSolution {
    public boolean wordPattern(String pattern, String str) {
//        Map<String, String> map = new HashMap<>();
//        Set<String> set = new HashSet<>();
//        String[] strs = str.split(" ");
//        if (pattern.length() != strs.length) {
//            return false;
//        }
//
//        for (int i = 0; i < pattern.length(); i++) {
//            String p = String.valueOf(pattern.charAt(i));
//            String temp = map.get(strs[i]);
//            if (temp == null) {
//                if (set.contains(p)) {
//                    // double words to one pattern
//                    return false;
//                }
//                map.put(strs[i], p);
//                set.add(p);
//                continue;
//            }
//            if (!p.equals(temp)) {
//                return false;
//            }
//        }
//        return true;

//        // 存取上一次pattern以及word出现的位置
//        String[] words = str.split(" ");
//        if (words.length != pattern.length())
//            return false;
//        Map index = new HashMap();
//        for (Integer i=0; i<words.length; ++i)
//            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
//                return false;
//        return true;

//        /*22222222222222222222222222222*/
//        ArrayList<String> b = new ArrayList<String>(Arrays.asList(str.split(" ")));
//
//        if (b.size() != pattern.length()) return false;
//        String[] map = new String[26];
//        HashSet<String> mapped = new HashSet<String>();
//        for (int i = 0; i < pattern.length(); i++) {
//            if (map[pattern.charAt(i) - 'a'] == null) {
//                if (mapped.contains(b.get(i))) return false;
//                mapped.add(b.get(i));
//                map[pattern.charAt(i) - 'a'] = b.get(i);
//            } else {
//                if (!map[pattern.charAt(i) - 'a'].equals(b.get(i))) return false;
//            }
//        }
//        return true;

        /*33333333333333333333333333*/
        String [] s = str.split(" ");
        if(s.length != pattern.length()) return false;
        String[] tmp = new String[26];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            int idx = pattern.charAt(i) - 'a';
            if(tmp[idx] != null){
                if (!tmp[idx].equals(s[i])) {
                    return false;
                }
            }
            else{
                if (!set.contains(s[i])){
                    tmp[idx] = s[i];
                    set.add(s[i]);
                } else {
                    return false;
                }
            }
        }
//        int i = 0;
//        while (i < pattern.length()) {
//            int idx = pattern.charAt(i) - 'a';
//            if (tmp[idx] == null) {
//                return false;
//            }
//            i++;
//        }
        return true;
    }

    @Override
    public Object run() {
        System.out.println(wordPattern("abca", "dog cat cat dog"));
        return null;
    }
}
