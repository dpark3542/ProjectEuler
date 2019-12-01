package solutions._300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Brute force with a few optimizations:
 *
 * First, 1 | n for all integer n, thus 1 + n/1 = 1 + n must be prime.
 * Thus iterate over primes p up to N = 10^8 and test p - 1.
 *
 * When testing an integer n, test divisors up to sqrt(n), since if ab = n then a + n/a = b + n/b.
 * Testing if d + n/d is prime using trial division will take O(sqrt(d + n/d)) time.
 * However, if primes less than d + n/d are stored, then we can prime check by binary search.
 * (Note: except for a few small cases, d + n/d <= n + 1, so we only need primes up to n. However, in the implementation below, I store all primes up to 10^8.)
 * By the prime number theorem, the number of primes less than m is O(m/ln m).
 * Thus prime checking d + n/d will take O(ln(n/ln n)) = O(ln n - ln ln n) = O(ln n) time.
 * Overall time to check n is O(ln(n) * sqrt(n)).
 *
 * n must be squarefree, else p + n/p is divisible by p.
 * Testing if n is squarefree can be done by iterating over primes p up to sqrt(n) and checking if n is divisible by p^2.
 * Checking if n is squarefree will take O(sqrt(n)/ln(sqrt(n)) = O(sqrt(n)/ln n).
 * Slightly faster than O(ln(n) * sqrt(n)), so this test will be run first.
 *
 */
public class Problem357 {
    public static void main(String[] args) {
        int n = 100000000;
        long sum = 0;
        List<Integer> primes = new ArrayList<>();
        out: for (int p = 2; p <= n; p++) {
            for (int q : primes) {
                if (q > Math.sqrt(p)) {
                    break;
                }
                if (p % q == 0) {
                    continue out;
                }
            }
            primes.add(p);
        }
        out: for (int p : primes) {
            p--;
            // check if p-1 squarefree
            for (int q : primes) {
                if (q > Math.sqrt(p)) {
                    break;
                }
                if (p % (q * q) == 0) {
                    continue out;
                }
            }
            // check if p-1 satisfies problem constraints
            for (int d = 2; d <= Math.sqrt(p); d++) {
                if (p % d == 0 && Collections.binarySearch(primes, d + p / d) < 0) {
                    continue out;
                }
            }
            sum += p;
        }
        System.out.println(sum);
    }
}
