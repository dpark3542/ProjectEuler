package solutions._000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.NumberTheory.isPrime;

/*
 * Brute force: loop through every pair of primes.
 * The third prime can be determined using the fact that the primes are an arithmetic sequence.
 * Test if the third prime is a permutation.
 *
 * Alternate brute force: loop through every prime, testing if its permutations are prime and form an arithmetic
 * sequence.
 *
 */
public class Problem049 {
    public static void main(String[] args) {
        List<Integer> pr = new ArrayList<>();
        for (int i = 1000; i <= 9999; i++) {
            if (isPrime(i)) {
                pr.add(i);
            }
        }
        for (int i : pr) {
            for (int j : pr) {
                if (i == j) {
                    continue;
                }
                int k = (i + j) / 2;
                if (isPrime(k) && isPermutation(i, j, k) && (i != 1487 || k != 4817 || j != 8147)) {
                    System.out.printf("%d%d%d\n", i, k, j);
                    return;
                }
            }
        }
    }

    private static boolean isPermutation(int x, int y, int z) {
        char[] a = Integer.toString(x).toCharArray(), b = Integer.toString(y).toCharArray(), c = Integer.toString(z).toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        return Arrays.equals(a, b) && Arrays.equals(b, c);
    }
}
