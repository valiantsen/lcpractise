package main.java.com.valiantsen.lcpractise.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the
 * minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the right.
 * 
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times
 * the watch could represent.
 * 
 * Example:
 * 
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should
 * be "10:02".
 * 
 * @ClassName: BinaryWatchE
 * @Description: T
 * @author zhangyasen
 * @date 2017年5月14日
 */
public class BinaryWatchE {

    public List<String> readBinaryWatch(int num) {
        int[] numsHour = { 8, 4, 2, 1 };
        int[] numsMinute = { 32, 16, 8, 4, 2, 1 };
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if (i <= 3 && num - i < 6) {
                List<Integer> hourList = generateStr(new ArrayList<Integer>(), numsHour, i);
                List<Integer> minuteList = generateStr(new ArrayList<Integer>(), numsMinute, num - i);
                // do combination
                for (Integer hour : hourList) {
                    if (hour < 12) {
                    for (Integer minute : minuteList) {
                            if (minute < 60)
                        result.add(
                                hour.toString() + ":" + (minute < 10 ? ("0" + minute.toString()) : minute.toString()));
                    }
                }
                }
            }
        }
        return result;
    }

    private List<Integer> generateStr(List<Integer> list, int[] region, int count) {
        generateHelper(list, region, count, 0, 0);
        return list;
    }

    private void generateHelper(List<Integer> list, int[] region, int count, int position, int sum) {
        if (count == 0) {
            list.add(sum);
            return;
        }
        for (int i = position; i < region.length; i++) {
            generateHelper(list, region, count - 1, i + 1, sum + region[i]);
        }
    }

    public List<String> readBinaryWatch1(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
    public static void main(String[] args) {

        System.out.println(Integer.bitCount(16));
        // BinaryWatchE w = new BinaryWatchE();
        // List<String> list = w.readBinaryWatch(2);
        // for (String s : list) {
        // System.out.println(s);
        // }
    }
}
