package solutions._000;

/*
 * For a given denominator d, the number of reduced fractions with denominator d is the number of numerators n such that gcd(n, d) = 1 and 1 <= n <= d.
 * By definition, this number is phi(d) where phi is the Euler totient function.
 * phi can be calculated using dynamic programming since phi is multiplicative. (See problem 70.)
 * Sum phi(d) over all denominators 2 <= d <= 10^6.
 *
 */
public class Problem072 {
    public static void main(String[] args) {
        // calculate phi
        int n = 1000000;
        int[] phi = new int[n + 1];
        phi[1] = 1;
        for (int i = 2; i <= n; i++) {
            // calculate phi[i]
            // find a prime factor j of i
            for (int j = 2; j <= Math.sqrt(i); j++) {
                int a = 1, b = i;
                while (b % j == 0) {
                    b /= j;
                    a *= j;
                }
                // if i divisible by j
                if (a != 1) {
                    // if i a power of j
                    if (b == 1) {
                        phi[i] = i - i / j;
                    }
                    // else, ab=i and a,b coprime
                    else {
                        phi[i] = phi[a] * phi[b];
                    }
                    break;
                }
            }
            // if i is prime
            if (phi[i] == 0) {
                phi[i] = i - 1;
            }
        }
        // sum phi
        long sum = 0;
        for (int d = 2; d <= n; d++) {
            sum += phi[d];
        }
        System.out.println(sum);
    }
}
