package solutions._000;

import static utils.NumberTheory.divisorCount;

/*
 * Brute force: compute the number of divisors of each triangle number.
 *
 */
public class Problem012 {
    public static void main(String[] args) {
        int T = 1;
        for (int n = 1; divisorCount(T) <= 500; n++) {
            T = n * (n + 1) / 2;
        }
        System.out.println(T);
    }
}
