package solutions._100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.sqrt;
import static java.math.BigInteger.valueOf;
import static utils.Miscellaneous.multinomial;

public class Problem171 {
    private static final int n = 20, t = 111111111, m = 1000000000;
    private static final BigInteger bm = valueOf(m);

    public static void main(String[] args) {
        System.out.println(dfs(new ArrayList<>(), 9, 0, 0));
    }

    private static long dfs(List<Integer> a, int i, int sum, int cnt) {
        if (i == 0) {
            int sq = (int) sqrt(sum);
            if (sq * sq != sum) {
                return 0;
            }

            long ans = 0;
            for (int j = 1; j < 10; j++) {
                if (a.get(9 - j) > 0) {
                    List<Integer> b = new ArrayList<>(a);
                    b.set(9 - j, a.get(9 - j) - 1);
                    b.add(n - cnt);
                    ans += j * t * multinomial(b).mod(bm).longValue();
                }
            }
            return ans % m;
        }

        long ans = 0;
        for (int j = 0; j <= n - cnt; j++) {
            List<Integer> c = new ArrayList<>(a);
            c.add(j);
            ans += dfs(c, i - 1, sum + i * i * j, cnt + j);
        }
        return ans % m;
    }
}
