package solutions._100;

import java.util.ArrayList;
import java.util.List;

import static utils.Miscellaneous.multinomial;

public class Problem172 {
    private static final int n = 18, m = 3;

    public static void main(String[] args) {
        System.out.println(dfs(new ArrayList<>()));
    }

    private static long dfs(List<Integer> a) {
        if (a.size() == 10) {
            int sum = 0;
            for (int x : a) {
                sum += x;
            }
            if (sum != n) {
                return 0;
            }

            long ans = multinomial(a).longValue();
            if (a.getFirst() > 0) {
                a.set(0, a.getFirst() - 1);
                ans -= multinomial(a).longValue();
            }
            return ans;
        }

        long ans = 0;
        for (int i = 0; i <= m; i++) {
            List<Integer> b = new ArrayList<>(a);
            b.add(i);
            ans += dfs(b);
        }
        return ans;
    }
}
