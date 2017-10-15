package main.java.com.valiantsen.lcpractise.math;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to
 * be less than 231 - 1.
 * 
 * For example, 123 -> "One Hundred Twenty Three" 12345 -> "Twelve Thousand Three Hundred Forty
 * Five" 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * @ClassName: IntegerToEnglishWords
 * @author zhangyasen
 * @date 2017年10月15日
 */
public class IntegerToEnglishWords {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"};

    private final String[] TENS =
            {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int thousands = 0;
        String word = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                word = help(num % 1000) + THOUSANDS[thousands] + " " + word;
            }
            num /= 1000;
            thousands++;
        }
        return word.trim();
    }

    // less then 1000
    private String help(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + help(num % 10);
        } else {
            return help(num / 100) + "Hundred " + help(num % 100);
        }
    }
}
