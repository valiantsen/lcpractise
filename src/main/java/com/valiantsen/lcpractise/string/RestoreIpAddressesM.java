package main.java.com.valiantsen.lcpractise.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address
 * combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @ClassName: RestoreIpAddressesM
 * @author zhangyasen
 * @date 2017年6月29日
 */
public class RestoreIpAddressesM {

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        valid(s, 0, 0, "", list);
        return list;
    }

    private void valid(String s, int index, int count, String ip, List<String> list) {
        if (count > 4)
            return;
        if (count == 4 && index == s.length())
            list.add(ip);
        for (int i = 1; i < 4 && (index + i) <= s.length(); i++) {
            String sub = s.substring(index, index + i);
            if (Integer.valueOf(sub) > 255 || (sub.startsWith("0") && sub.length() > 1))
                return;

            valid(s, index + i, count + 1, ip + (count == 0 ? "" : ".") + sub, list);
        }
    }

    public List<String> solution(String s) {
        List<String> list = new ArrayList<>();
        restoreIp(s, list, 0, "", 0);
        return list;
    }

    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4)
            return;
        if (count == 4 && idx == ip.length())
            solutions.add(restored);

        for (int i = 1; i < 4; i++) {
            if (idx + i > ip.length())
                break;
            String s = ip.substring(idx, idx + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256))
                continue;
            restoreIp(ip, solutions, idx + i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }

    public static void main(String[] args) {
        RestoreIpAddressesM m = new RestoreIpAddressesM();
        // m.solution("010010");
        m.restoreIpAddresses("010010");
    }
}
