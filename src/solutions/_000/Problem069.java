package solutions._000;

import static utils.NumberTheory.isPrime;

/*
 * Brute force is a viable option.
 *
 * Alternative solution:
 * It is well-known that phi(n) = n  * prod_{p|n} (1-1/p).
 * Then n/phi(n) = prod_{p|n} p/(p-1).
 * Note p/(p-1) is a decreasing function greater than 1.
 * Thus the n which maximizes n/phi(n) and n <= 10^6 is n = p_1 * ... * p_k where k is maximal.
 *
 */
public class Problem069 {
    public static void main(String[] args) {
        int n = 1;
        for (int i = 2; i <= 1000000 / n; i++) {
            if (isPrime(i)) {
                n *= i;
            }
        }
        System.out.println(n);
    }
}
