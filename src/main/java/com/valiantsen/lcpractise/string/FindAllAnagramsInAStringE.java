package main.java.com.valiantsen.lcpractise.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc". The
 * substring with start index = 6 is "bac", which is an anagram of "abc". Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * 
 * Explanation: The substring with start index = 0 is "ab", which is an anagram of "ab". The
 * substring with start index = 1 is "ba", which is an anagram of "ab". The substring with start
 * index = 2 is "ab", which is an anagram of "ab".
 * 
 * @ClassName: FindAllAnagramsInAStringE
 * @author zhangyasen
 * @date 2017年9月2日
 */
public class FindAllAnagramsInAStringE {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        if (s == null || s.length() < p.length())
            return resultList;
        int l = p.length();
        for (int i = 0; i < s.length() - l + 1; i++) {
            String sub = s.substring(i, i + l);
            if (isAnagram(sub, p))
                resultList.add(i);
        }
        return resultList;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0)
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;
        int[] hash = new int[256]; // character hash
        // record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        // two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            // move right everytime, if the character exists in p's hash, decrease the count
            // current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1)
                count--;

            // when the count is down to 0, means we found the right anagram
            // then add window's left to result list
            if (count == 0)
                list.add(left);

            // if we find the window's size equals to p, then we have to move left (narrow the
            // window) to find the new match window
            // ++ to reset the hash because we kicked out the left
            // only increase the count if the character is in p
            // the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
                count++;
        }
        return list;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        if (s == null || s.length() < p.length())
            return resultList;
        int[] counter = new int[26];
        for (char ch : p.toCharArray()) {
            counter[ch - 'a']++;
        }
        int left = 0, right = 0, numer = p.length();
        while (right < s.length()) {
            if (counter[s.charAt(right++) - 'a']-- >= 1)
                numer--;

            if (numer == 0)
                resultList.add(left);

            if (right - left == p.length() && counter[s.charAt(left++) - 'a']++ >= 0)
                numer++;
        }
        return resultList;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAStringE obj = new FindAllAnagramsInAStringE();
        String s = "cbaebabacd", p = "abc";
        List<Integer> indexList = obj.findAnagrams3(s, p);
        for (Integer i : indexList) {
            System.out.println(i);
        }
    }
}
