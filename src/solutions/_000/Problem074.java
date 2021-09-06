package solutions._000;

import java.util.HashSet;
import java.util.Set;

/**
 * Brute force.
 */
public class Problem074 {
    public static void main(String[] args) {
        int[] f = new int[10];
        f[0] = 1;
        for (int i = 1; i <= 9; i++) {
            f[i] = f[i - 1] * i;
        }

        int ans = 0;
        for (int i = 0; i < 1000000; i++) {
            Set<Integer> s = new HashSet<>();
            int j = i;
            while (!s.contains(j)) {
                s.add(j);
                int k = 0;
                while (j > 0) {
                    k += f[j % 10];
                    j /= 10;
                }
                j = k;
            }
            if (s.size() == 60) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
