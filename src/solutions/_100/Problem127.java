package solutions._100;

import utils.structs.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem127 {
    private static final int n = 120000;

    public static void main(String[] args) {
        int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            r[i] = rad(i);
        }

        long sum = 0;
        Deque<Pair<Integer, Integer>> st = new ArrayDeque<>();
        st.addLast(new Pair<>(2, 1));
        st.addLast(new Pair<>(3, 1));
        while (!st.isEmpty()) {
            Pair<Integer, Integer> p = st.pollLast();
            int b = p.first(), a = p.second();
            if ((long) r[a] * r[b] * r[a + b] < a + b) {
                sum += a + b;
            }
            if (3 * b - a < n) {
                st.addLast(new Pair<>(2 * b - a, b));
            }
            if (3 * b + a < n) {
                st.addLast(new Pair<>(2 * b + a, b));
            }
            if (b + 3 * a < n) {
                st.addLast(new Pair<>(b + 2 * a, a));
            }
        }
        System.out.println(sum);
    }

    private static int rad(int k) {
        int p = 1;
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                p *= i;
            }
            while (k % i == 0) {
                k /= i;
            }
        }
        return p * k;
    }
}
