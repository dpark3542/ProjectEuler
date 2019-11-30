package solutions._000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Brute force by number of digits.
 * For each n, find all cubes x with n digits.
 * Convert x to a string and sort the string.
 * Keep a count for the number of times each sorted string appears and the corresponding smallest cube for each sorted string.
 * Stop when such a cube has been found.
 *
 */
public class Problem062 {
    public static void main(String[] args) {
        // flag if cube has been found
        boolean flag = true;
        long ans = Long.MAX_VALUE;
        for (int n = 1; flag; n++) {
            // cnt is number of times string has been found
            // min is smallest cube corresponding to the string
            Map<String, Integer> cnt = new HashMap<>();
            Map<String, Long> min = new HashMap<>();
            // iterate through all cubes i^3
            for (int i = (int) Math.ceil(Math.pow(10, (double) (n - 1) / 3)); i < Math.pow(10, (double) n / 3); i++) {
                long x = (long) i * i * i;
                // find string
                char[] a = Long.toString(x).toCharArray();
                Arrays.sort(a);
                String s = new String(a);
                // update cnt and min
                cnt.put(s, cnt.getOrDefault(s, 0) + 1);
                if (!min.containsKey(s)) {
                    min.put(s, x);
                }
            }
            // find cubes with 5 permutations
            for (Map.Entry<String, Integer> e : cnt.entrySet()) {
                if (e.getValue() == 5) {
                    ans = Math.min(ans, min.get(e.getKey()));
                    flag = false;
                }
            }
        }
        System.out.println(ans);
    }
}
