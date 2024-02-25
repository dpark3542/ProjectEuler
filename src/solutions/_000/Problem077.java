package solutions._000;

import java.util.ArrayList;
import java.util.List;

/**
 * Dynamic programming.
 * dp[i][j] = ways to partition i with first j primes.
 * dp[i][j] = \sum_{k=0}^{\lfloor i/p_j \rfloor} dp[i-kp_j][j-1]
 */
public class Problem077 {
    public static void main(String[] args) {
        int lim = 5000, n = 2, m = 1;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        List<List<Integer>> dp =  new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.add(new ArrayList<>());
        dp.getFirst().add(1);
        dp.get(1).add(0);
        while (true) {
            List<Integer> row = new ArrayList<>();
            dp.add(row);
            row.add(0);
            for (int j = 1; j <= m; j++) {
                int x = 0, p = primes.get(j - 1);
                for (int i = n; i >= 0; i -= p) {
                    x += dp.get(i).get(j - 1);
                }
                if (x > lim) {
                    System.out.println(n);
                    return;
                }
                row.add(x);
            }

            // add new column if n is prime
            boolean flag = true;
            for (int p : primes) {
                if (n % p == 0) {
                    flag = false;
                    break;
                }
                if (p * p >= n) {
                    break;
                }
            }
            if (flag) {
                primes.add(n);
                for (int i = 0; i < n; i++) {
                    row = dp.get(i);
                    row.add(row.getLast());
                }
                row = dp.get(n);
                row.add(row.getLast() + 1);
                m++;
            }

            n++;
        }
    }
}
