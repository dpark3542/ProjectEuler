package solutions._100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem119 {
    private static final int m = 30;

    public static void main(String[] args) {
        int cnt = 0, n = 2;
        long p = 100;
        while (true) {
            List<Long> a = new ArrayList<>();

            for (int i = n; i <= 9 * n; i++) {
                for (long j = i; j < p; j *= i) {
                    if (j < p / 10) {
                        continue;
                    }

                    int sum = 0;
                    for (long k = j; k > 0; k /= 10) {
                        sum += (int) (k % 10);
                    }
                    if (sum == i) {
                        a.add(j);
                    }
                }
            }

            if (cnt + a.size() >= m) {
                Collections.sort(a);
                System.out.println(a.get(m - cnt - 1));
                return;
            }

            cnt += a.size();
            n++;
            p *= 10;
        }
    }
}
