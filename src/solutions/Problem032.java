package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpark on 5/13/2017.
 */
public class Problem032 {
    public static void main(String[] args) {
        Set<Integer> prod = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1000; j <= 9999; j++) {
                if (pandigitalQ(i, j, i * j)) {
                    prod.add(i * j);
                }
            }
        }
        for (int i = 10; i <= 99; i++) {
            for (int j = 100; j <= 999; j++) {
                if (pandigitalQ(i, j, i * j)) {
                    prod.add(i * j);
                }
            }
        }
        int sum = 0;
        for (int e : prod) {
            sum += e;
        }
        System.out.println(sum);
    }

    private static boolean pandigitalQ(int a, int b, int c) {
        int[] l = {a, b, c};
        boolean[] mkd = new boolean[10];
        mkd[0] = true;
        for (int e : l) {
            while (e > 0) {
                if (!mkd[e % 10]) {
                    mkd[e % 10] = true;
                    e /= 10;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
