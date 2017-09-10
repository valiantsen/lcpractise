package main.java.com.valiantsen.ama.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFindMax {

    public String[] getLargestUnion(String[][] friends) {

        Map<String, String> map = new HashMap<>();
        // 初始化分组，每人单独一组
        for (String[] records : friends) {
            map.put(records[0], records[0]);
            map.put(records[1], records[1]);
        }
        // 计数
        Map<String, Integer> countMap = new HashMap<>();
        // union操作
        for (String[] pairs : friends) {
            String key0 = map.get(pairs[0]), key1 = map.get(pairs[1]);
            if (key0.compareTo(key1) < 0) {
                map.put(pairs[1], key0);
            } else {
                map.put(pairs[0], key1);
            }
        }
        // 寻找最大的集合
        String maxGroup = "";
        int max = -1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            countMap.put(entry.getValue(),
                    countMap.get(entry.getValue()) == null ? 0 : countMap.get(entry.getValue()) + 1);
            if (countMap.get(entry.getValue()) > max
                    || (countMap.get(entry.getValue()) == max && entry.getValue().compareTo(maxGroup) < 0)) {
                max = countMap.get(entry.getValue());
                maxGroup = entry.getValue();
            }
        }
        List<String> result = new ArrayList<>(max);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(maxGroup)) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[][] friends = {{"A", "B"}, {"B", "F"}, {"F", "C"}, {"C", "D"}, {"D", "E"}};
        UnionFindMax a = new UnionFindMax();
        String[] result = a.getLargestUnion(friends);
        for (String str : result) {
            System.out.println(str);
        }
    }

}
