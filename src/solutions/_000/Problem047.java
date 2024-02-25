package solutions._000;

import java.util.HashSet;
import java.util.Set;

/*
 * Brute force: test each quadruple of consecutive integers.
 */
public class Problem047 {
    public static void main(String[] args) {
        int i = 1;
        boolean[] a = new boolean[4];
        for (; !(a[0] && a[1] && a[2] && a[3]); i++) {
            int p = 2, j = i + 3;
            Set<Integer> pf = new HashSet<>();
            while (j > 1) {
                if (j % p == 0) {
                    j /= p;
                    pf.add(p);
                }
                else {
                    p++;
                }
            }
            a[i % 4] = pf.size() == 4;
        }
        System.out.println(i - 1);
    }
}
