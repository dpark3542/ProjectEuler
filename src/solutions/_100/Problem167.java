package solutions._100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Schmerl and Spiegel proved for odd v >= 5, U(2, v) has two even terms: 2 and 2v + 2.
 * Finch proved a 1-additive sequence with finitely many even terms is regular.
 * The repeating part of the differences can be found by following Finch's proof.
 */
public class Problem167 {
    private static final long k = 100000000000L;

    public static void main(String[] args) {
        long ans = 0;
        for (int v = 5; v <= 21; v += 2) {
            List<Integer> a = new ArrayList<>();
            a.add(0);
            a.add(0);
            a.add(1);
            for (int i = 3; i < v; i++) {
                a.add(0);
            }
            for (int i = v; i <= 2 * v + 1; i++) {
                a.add(i % 2);
            }
            a.add(1);

            int period;
            Map<List<Integer>, Integer> map = new HashMap<>();
            map.put(key(a, v), a.size());
            for (int i = 2 * v + 3; true; i++) {
                if (i % 2 == 0) {
                    a.add(0);
                } else {
                    a.add((a.get(i - 2) == 1 ? 1 : 0) + (a.get(i - 2 * v - 2) == 1 ? 1 : 0));
                    List<Integer> key = key(a, v);
                    if (map.containsKey(key)) {
                        period = a.size() - map.get(key);
                        break;
                    }
                    map.put(key, a.size());
                }
            }

            ans += a.size() - period - 1;
            long j = k;
            for (int i = 0 ; i + period < a.size(); i++) {
                if (a.get(i) == 1) {
                    j--;
                }
            }

            a = a.subList(a.size() - period, a.size());
            int d = 0;
            for (int x : a) {
                if (x == 1) {
                    d++;
                }
            }
            ans += period * (j / d);
            j %= d;

            for (int i = 1; true; i++) {
                if (a.get(a.size() - period + i - 1) == 1) {
                    j--;
                }
                if (j == 0) {
                    ans += i;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    private static List<Integer> key(List<Integer> a, int v) {
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            b.add(a.get(a.size() - 2 * i - 1));
        }
        return b;
    }
}
