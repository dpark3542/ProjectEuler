package solutions._000;

import java.util.ArrayList;
import java.util.List;

import static utils.NumberTheory.isPrime;

/*
 *  Brute force: test each sum of primes in decreasing order of number of primes.
 *  An optimization can be made using dynamic programming in calculating the sum of primes; store the sum of the
 *  first n primes.
 */
public class Problem050 {
    public static void main(String[] args) {
        List<Integer> pr = new ArrayList<>();
        for (int i = 2; i < 1000000; i++) {
            if (isPrime(i)) {
                pr.add(i);
            }
        }
        int n = pr.size();
        long[] dp = new long[n];
        dp[0] = pr.getFirst();
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + pr.get(i);
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j + i < n; j++) {
                long sum = dp[j + i];
                if (j > 0) {
                    sum -= dp[j - 1];
                }
                if (sum >= 1000000) {
                    break;
                }
                if (isPrime(sum)) {
                    System.out.println(sum);
                    return;
                }
            }
        }
    }
}
