package solutions._100;

/**
 * Let $a_n,b_n$ be the number of ways ending in a red/gray square respectively.
 * \begin{align*}
 *     a_n &= a_{n-1} + b_{n-3}\\
 *     b_n &= a_{n-1} + b_{n-1}
 * \end{align*}
 */
public class Problem114 {
    private static final int n = 50;

    public static void main(String[] args) {
        long[] a = new long[n + 1], b = new long[n + 1];

        a[3] = 1;
        b[1] = 1;
        b[2] = 1;
        b[3] = 1;

        for (int i = 4; i <= n; i++) {
            a[i] = a[i - 1] + b[i - 3];
            b[i] = a[i - 1] + b[i - 1];
        }

        System.out.println(a[n] + b[n]);
    }
}
