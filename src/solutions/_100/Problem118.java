package solutions._100;

import java.util.ArrayList;
import java.util.List;

import static utils.Miscellaneous.generateNextPermutation;
import static utils.NumberTheory.isPrime;

public class Problem118 {
    private static final int n = 9;

    public static void main(String[] args) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        int ans = 0;
        while (true) {
            for (int i = 0, x = a[0]; 2 * i + 2 <= n; i++, x = 10 * x + a[i]) {
                if (isPrime(x)) {
                    List<Integer> b = new ArrayList<>();
                    for (int j = i + 1; j < n; j++) {
                        b.add(a[j]);
                    }
                    ans += dfs(b, x);
                }
            }

            if (!generateNextPermutation(a)) {
                break;
            }
        }

        System.out.println(ans);
    }

    private static int dfs(List<Integer> a, int min) {
        int ans = 0;

        int x = 0;
        for (int y : a) {
            x = 10 * x + y;
        }
        if (x > min && isPrime(x)) {
            ans++;
        }

        for (int i = 0, y = a.get(0); 2 * i + 2 <= a.size(); i++, y = 10 * y + a.get(i)) {
            if (y > min && isPrime(y)) {
                ans += dfs(a.subList(i + 1, a.size()), y);
            }
        }
        return ans;
    }
}
