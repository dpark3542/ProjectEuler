package solutions._000;

import java.util.HashSet;
import java.util.Set;

import static java.lang.StrictMath.min;
import static java.lang.StrictMath.sqrt;

public class Problem095 {
    public static void main(String[] args) {
        int n = 1000000, ans = 0, max = 0;
        for (int i = 2; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            int c = 0, x = i, j = i;
            while (j < n && !s.contains(j)) {
                s.add(j);
                x = min(x, j);
                c++;
                int sum = 1;
                for (int k = 2; k < sqrt(j); k++) {
                    if (j % k == 0) {
                        sum += k + j / k;
                    }
                }
                int sq = (int) sqrt(j);
                if (sq * sq == j) {
                    sum += sq;
                }
                j = sum;
            }
            if (j == i) {
                if (c > max) {
                    max = c;
                    ans = x;
                }
                else if (c == max) {
                    ans = min(ans, x);
                }
            }
        }
        System.out.println(ans);
    }
}
