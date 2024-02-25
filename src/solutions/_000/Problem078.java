package solutions._000;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.ceil;
import static java.lang.StrictMath.sqrt;

/**
 * Partitions are well known.
 */
public class Problem078 {
    private static final int MOD = 1000000;

    public static void main(String[] args) {
        List<Integer> p = new ArrayList<>();
        p.add(1);
        for (int i = 1; ; i++) {
            int x = 0;
            for (int k = (int) ceil((1 - sqrt(24 * i + 1)) / 6); k <= (sqrt(24 * i + 1) + 1) / 6; k++) {
                if (k != 0) {
                    int j = i - k * (3 * k - 1) / 2;
                    if (k % 2 == 0) {
                        x = (x - p.get(j)) % MOD;
                    } else {
                        x = (x + p.get(j)) % MOD;
                    }
                }
            }
            if (x == 0) {
                System.out.println(p.size());
                return;
            }
            p.add(x);
        }
    }
}
