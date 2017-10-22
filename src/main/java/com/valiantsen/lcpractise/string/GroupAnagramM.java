package main.java.com.valiantsen.lcpractise.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ] Note: All inputs will be in lower-case.
 * 
 * @ClassName: GroupAnagramM
 * @author zhangyasen
 * @date 2017年10月21日
 */
public class GroupAnagramM {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (map.get(keyStr) == null) {
                List<String> list = new ArrayList<>();
                map.put(keyStr, list);
            }
            map.get(keyStr).add(strs[i]);

        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagramM a = new GroupAnagramM();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> r = a.groupAnagrams(strs);
        System.out.println(r.size());
    }
}
