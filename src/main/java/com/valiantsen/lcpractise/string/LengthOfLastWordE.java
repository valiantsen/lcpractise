/**
 * Copyright (c) 2017, DiDiChuXing. All rights reserved.
 */
package main.java.com.valiantsen.lcpractise.string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return
 * the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @ClassName: LengthOfLastWordE
 * @author zhangyasen
 * @date 2017年6月22日
 */
public class LengthOfLastWordE {
    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        int last = 0, now = 0;
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                now++;
            } else {
                if (now != 0)
                    last = now;
                now = 0;
            }
        }
        if (now != 0)
            last = now;
        return last;
    }
}
