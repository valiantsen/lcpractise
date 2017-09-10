package main.java.com.valiantsen.ama.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitList {

    public static int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
        int listSize = 0, start = 0, now = 0, subListNum = 0;
        while (listSize < codeList.size() && now < shoppingCart.size()) {
            List<String> subList = codeList.get(listSize);
            subListNum = 0;
            while (subListNum < subList.size() && now < shoppingCart.size()) {
                if (subList.get(subListNum).equals(shoppingCart.get(now))) {
                    subListNum++;
                    now++;
                } else {
                    subListNum = 0;
                    start++;
                    now = start;
                }
            }
            if (subListNum != subList.size()) {
                return 0;
            }
            start = now;
            listSize++;
        }
        if (listSize != codeList.size()) {
            return 0;
        }
        return 1;
    }


    public static void main(String[] args) {
        List<List<String>> codeList = new ArrayList<>();
        List<String> a = Arrays.asList("orange", "banana");
        List<String> b = Arrays.asList("mango", "apple");
        List<String> c = Arrays.asList("orange", "apple");
        codeList.add(a);
        codeList.add(b);
        codeList.add(c);
        List<String> shop = Arrays.asList("orange", "banana", "shit", "orange", "mango", "apple", "apple");

        System.out.println(checkWinner(codeList, shop));
    }
}
