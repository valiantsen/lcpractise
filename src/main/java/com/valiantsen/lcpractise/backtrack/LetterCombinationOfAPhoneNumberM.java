package main.java.com.valiantsen.lcpractise.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * 
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @ClassName: LetterCombinationOfAPhoneNumberM
 * @author zhangyasen
 * @date 2017年8月26日
 */
public class LetterCombinationOfAPhoneNumberM {
    private static final String[] charmap =
            {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        genLetter(resultList, digits, 0, "");
        return resultList;
    }

    private void genLetter(List<String> resultList, String digits, int count, String temp) {
        if (count >= digits.length()) {
            if (!"".equals(temp))
                resultList.add(temp);
        } else {
            String letters = charmap[digits.charAt(count) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                genLetter(resultList, digits, count + 1, temp + letters.charAt(i));
            }
        }
    }
}
