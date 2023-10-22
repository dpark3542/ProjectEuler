package solutions._100;

import java.util.ArrayList;
import java.util.List;

/**
 * Let $a_n,b_n$ be the number of ways ending in a red/gray square respectively.
 * \begin{align*}
 *     a_n &= a_{n-1} + b_{n-50}\\
 *     b_n &= a_{n-1} + b_{n-1}
 * \end{align*}
 */
public class Problem115 {
    private static final int m = 50;
    private static final int LIM = 1000000;

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            a.add(0);
            b.add(1);
        }
        a.add(1);
        b.add(1);

        int i = m;
        while (a.get(i) + b.get(i) <= LIM) {
            a.add(a.get(i) + b.get(i - m + 1));
            b.add(a.get(i) + b.get(i));
            i++;
        }

        System.out.println(i);
    }
}
