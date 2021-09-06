package solutions._000;

import static utils.NumberTheory.phi;

/*
 * For a given denominator d, the number of reduced fractions with denominator d is the number of numerators n such that gcd(n, d) = 1 and 1 <= n <= d.
 * By definition, this number is phi(d) where phi is the Euler totient function.
 * Sum phi(d) over all denominators 2 <= d <= 10^6.
 *
 */
public class Problem072 {
    public static void main(String[] args) {
        int n = 1000000;
        int[] phi = phi(n + 1);
        // sum phi
        long sum = 0;
        for (int d = 2; d <= n; d++) {
            sum += phi[d];
        }
        System.out.println(sum);
    }
}
