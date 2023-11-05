package solutions._100;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem127 {
    public static void main(String[] args) {
        int lim = 120000;
        int[] r = new int[lim];
        for (int i = 1; i < lim; i++) {
            r[i] = rad(i);
        }
        long sum = 0;
        Deque<Integer> x = new ArrayDeque<>(), y = new ArrayDeque<>();
        x.addLast(2);
        y.addLast(1);
        x.addLast(3);
        y.addLast(1);
        while (!x.isEmpty()) {
            int m = x.pollLast(), n = y.pollLast();
            if (m + n >= lim) {
                continue;
            }
            if ((long) r[m] * r[n] * r[m + n] < m + n) {
                sum += m + n;
            }
            x.addLast(2 * m - n);
            y.addLast(m);
            x.addLast(2 * m + n);
            y.addLast(m);
            x.addLast(m + 2 * n);
            y.addLast(n);
        }
        System.out.println(sum);
    }

    private static int rad(int n) {
        int x = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                x *= i;
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        return x * n;
    }
}
