package main.java.com.valiantsen.lcpractise.string;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @ClassName: RomanToIntegerE
 * @author zhangyasen
 * @date 2017年10月2日
 */
public class RomanToIntegerE {

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                default:
                    break;
            }
        }
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j] < nums[j + 1]) {
                sum -= nums[j];
            } else {
                sum += nums[j];
            }
        }
        return sum;
    }
}
