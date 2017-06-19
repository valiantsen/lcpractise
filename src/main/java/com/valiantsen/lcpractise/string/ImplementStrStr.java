/**
 * Copyright (c) 2017, DiDiChuXing. All rights reserved.
 */
package main.java.com.valiantsen.lcpractise.string;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 * 
 * @ClassName: ImplementStrStr
 * @author zhangyasen
 * @date 2017年6月19日
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length())
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }
}
