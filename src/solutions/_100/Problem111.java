package solutions._100;

import java.util.ArrayList;
import java.util.List;

import static utils.NumberTheory.isPrime;

public class Problem111 {
    private static final int n = 10;

    public static void main(String[] args) {
        long ans = 0;
        for (int d = 0; d <= 9; d++) {
            long cur = 0;
            for (int m = n - 1; cur == 0 && m > 0; m--) {
                for (int j = 1; j <= 9; j++) {
                    cur += dfs(List.of(j), d, d == j ? m - 1 : m);
                }
            }
            ans += cur;
        }
        System.out.print(ans);
    }

    private static long dfs(List<Integer> a, int d, int m) {
        if (m == 0) {
            long pow = 1;
            for (int i = 0; i < n - a.size(); i++) {
                pow *= 10;
            }

            long x = 0;
            for (int y : a) {
                x = 10 * x + y;
            }
            x *= pow;

            long ans = 0;
            for (int i = 1; i < pow; i += 2) {
                if (isPrime(x + i)) {
                    ans += x + i;
                }
            }

            return ans;
        } else if (a.size() + m == n) {
            long x = 0;
            for (int y : a) {
                x = 10 * x + y;
            }
            for (int i = 0; i < m; i++) {
                x = 10 * x + d;
            }
            return isPrime(x) ? x : 0;
        } else {
            long ans = 0;
            for (int i = 0; i <= 9; i++) {
                List<Integer> b = new ArrayList<>(a);
                b.add(i);
                ans += dfs(b, d, i == d ? m - 1 : m);
            }
            return ans;
        }
    }
}
