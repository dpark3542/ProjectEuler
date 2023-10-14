package solutions._000;

/**
 * Brute force: iterate over b, c and test if (1000 - b - c)^2 + b^2 = c^2.
 * Alternatively, iterate over factors of 1000^2:
 * \begin{align*}
 *     a^2 + b^2 &= (1000-a-b)^2\\
 *     2ab - 2000a - 2000b + 1000^2 &= 0\\
 *     2(a - 1000)(b - 1000) &= 1000^2
 * end{align*}
 */
public class Problem009 {
    public static void main(String[] args) {
        out:
        for (int c = 1; c < 1000; c++) {
            for (int b = (1000 - c) / 2; b < c; b++) {
                if ((1000 - b - c) * (1000 - b - c) + b * b == c * c) {
                    System.out.println((1000 - b - c) * b * c);
                    break out;
                }
            }
        }
    }
}
