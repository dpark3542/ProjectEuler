package solutions._100;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem139 {
    public static void main(String[] args) {
        int cnt = 0, lim = 100000000;
        Deque<Integer> x = new ArrayDeque<>(), y = new ArrayDeque<>();
        x.addLast(2);
        y.addLast(1);
        while (!x.isEmpty()) {
            int m = x.pollLast(), n = y.pollLast();
            int a = m * m - n * n, b = 2 * m * n, c = m * m + n * n;
            if (a + b + c >= lim) {
                continue;
            }
            if (c % Math.abs(b - a) == 0) {
                cnt += (lim - 1) / (a + b + c);
            }
            x.addLast(2 * m - n);
            y.addLast(m);
            x.addLast(2 * m + n);
            y.addLast(m);
            x.addLast(m + 2 * n);
            y.addLast(n);
        }
        System.out.println(cnt);
    }
}
