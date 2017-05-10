package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dpark on 5/7/2017.
 */
public class Problem017 {
    public static void main(String[] args) {
        int tot = 0;
        initMap();
        for (int i = 1; i <= 1000; i++) {
            String s = convert(i);
            System.out.println(s);
            for (char c : s.toCharArray()) {
                if (c != ' ' && c != '-') {
                    tot++;
                }
            }
        }
        System.out.println(tot);
    }

    private static Map<Integer, String> map;

    private static void initMap() {
        map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
        map.put(1000, "one thousand");
    }

    private static String convert(int x) {
        if (map.containsKey(x)) {
            return map.get(x);
        }
        String s = "";
        if (x >= 100) {
            s += map.get(x / 100) + " hundred ";
            if (x % 100 != 0) {
                s += "and ";
            }
        }
        if (map.containsKey(x % 100)) {
            s += map.get(x % 100);
        }
        else if (x % 100 != 0) {
            s += map.get(x % 100 - x % 10) + "-" + map.get(x % 10);
        }
        return s;
    }
}
