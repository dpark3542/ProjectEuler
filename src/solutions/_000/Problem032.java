package solutions._000;

import java.util.HashSet;
import java.util.Set;

/*
 * Brute force: test all possible combinations of multiplicands and multipliers.
 * An optimization can be made in noticing that the product must be a 1-digit number times a 4-digit number or a
 * 2-digit number times a 3-digit number, otherwise the number of digits will not turn out to be 9.
 */
public class Problem032 {
    public static void main(String[] args) {
        Set<Integer> prod = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1000; j <= 9999; j++) {
                if (isPandigital(i, j, i * j)) {
                    prod.add(i * j);
                }
            }
        }
        for (int i = 10; i <= 99; i++) {
            for (int j = 100; j <= 999; j++) {
                if (isPandigital(i, j, i * j)) {
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

    private static boolean isPandigital(int a, int b, int c) {
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
