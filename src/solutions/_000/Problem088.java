package solutions._000;

import java.util.*;

public class Problem088 {
    private static final int n = 12000;
    private static final List<List<Integer>> a = new ArrayList<>(); // contains factors up to sqrt(n)
    private static int[] b = new int[n + 1]; // minimal product-sum number
    private static int cnt = 0;

    private static void f(int res, int min, int ind, int k) {
        if (min * min <= res) {
            int i = Collections.binarySearch(a.get(res), min);
            if (i < 0) {
                i = -i - 1;
            }
            while (i < a.get(res).size()) {
                int x = a.get(res).get(i);
                f(res / x, x, ind - x + 1, k);
                i++;
            }
        }
        ind -= res - 1;
        if (ind <= n) {
            if (b[ind] == 0) {
                cnt++;
                b[ind] = k;
            } else if (b[ind] > k) {
                b[ind] = k;
            }
        }
    }

    public static void main(String[] args) {
        a.add(new ArrayList<>());
        a.add(new ArrayList<>());
        for (int k = 2; cnt < n - 1; k++) {
            a.add(new ArrayList<>());
            for (int i = 2; i * i <= k; i++) {
                if (k % i == 0) {
                    a.get(k).add(i);
                    f(k / i, i, k - i + 1, k);
                }
            }
        }
        Set<Integer> s = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            s.add(b[i]);
        }
        int tot = 0;
        for (int x : s) {
            tot += x;
        }
        System.out.println(tot);
    }
}
