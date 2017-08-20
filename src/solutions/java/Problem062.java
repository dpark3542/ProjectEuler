package solutions.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dpark3542 on 7/21/2017.
 */
public class Problem062 {
    public static void main(String[] args) {
        boolean flag = true;
        int n = 1;
        long ans = Long.MAX_VALUE;
        while (flag) {
            Map<String, Integer> cnt = new HashMap<>();
            Map<String, Long> min = new HashMap<>();
            for (int i = (int) Math.ceil(Math.pow(10, (double) (n - 1) / 3)); i < Math.pow(10, (double) n / 3); i++) {
                long x = (long) i * i * i;
                char[] a = Long.toString(x).toCharArray();
                Arrays.sort(a);
                String s = new String(a);
                cnt.put(s, cnt.getOrDefault(s, 0) + 1);
                if (!min.containsKey(s)) {
                    min.put(s, x);
                }
            }
            for (Map.Entry<String, Integer> e : cnt.entrySet()) {
                if (e.getValue() == 5) {
                    ans = Math.min(ans, min.get(e.getKey()));
                    flag = false;
                }
            }
            n++;
        }
        System.out.println(ans);
    }
}
