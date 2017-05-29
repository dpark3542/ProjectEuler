package solutions.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpark3542 on 5/22/2017.
 */
public class Problem047 {
    /*
     * Brute force: test each quadruple of consecutive integers.
     *
     */
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

    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
