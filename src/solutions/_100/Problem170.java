package solutions._100;

import java.util.ArrayList;
import java.util.List;

import static utils.Miscellaneous.generatePreviousPermutation;

public class Problem170 {
    private static final int n = 10;

    public static void main(String[] args) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i - 1;
        }

        while (true) {
            long x = 0;
            for (int i = 0; i < n; i++) {
                x = 10 * x + a[i];
            }
            out: for (int i = 2; (long) i * i <= x; i++) {
                if (x % i != 0) {
                    continue;
                }

                int[] cnt = new int[n];
                for (int j = i; j > 0; j /= 10) {
                    cnt[j % 10]++;
                }
                for (long j = x / i; j > 0; j /= 10) {
                    cnt[(int) (j % 10)]++;
                }

                if (cnt[0] == 0) {
                    continue;
                }
                for (int j = 1; j < n; j++) {
                    if (cnt[j] != 1) {
                        continue out;
                    }
                }
                if (dfs(x, i, new ArrayList<>())) {
                    System.out.println(x);
                    return;
                }
            }
            generatePreviousPermutation(a);
        }
    }

    private static boolean dfs(long num, int denom, List<Long> path) {
        for (long p = 10, m = num / 10; m > 0; p *= 10, m /= 10) {
            if ((num % p) % denom == 0 && m % denom == 0) {
                List<Long> q = new ArrayList<>(path);
                q.add((num % p) / denom);
                if (dfs(m, denom, q)) {
                    return true;
                }
            }
        }

        if (path.isEmpty()) {
            return false;
        }

        int tot = 0;
        boolean[] mkd = new boolean[n];
        path.add(num / denom);
        path.add((long) denom);
        for (long x : path) {
            if (x == 0) {
                if (mkd[0]) {
                    return false;
                }
                mkd[0] = true;
            } else {
                while (x > 0) {
                    tot++;
                    int i = (int) (x % 10);
                    if (mkd[i]) {
                        return false;
                    }
                    mkd[i] = true;
                    x /= 10;
                }
            }
        }

        return tot == n;
    }
}
