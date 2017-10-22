package main.java.com.valiantsen.lcpractise.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both
 * 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 
 * @ClassName: SortCharactersByFrequencyM
 * @author zhangyasen
 * @date 2017年10月21日
 */
public class SortCharactersByFrequencyM {
    public String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>(s.length());
        List<Character>[] bucket = new List[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<Character>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i > -1; i--) {
            if (bucket[i] != null) {
                for (Character c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
