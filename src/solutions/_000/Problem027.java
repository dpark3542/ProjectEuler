package solutions._000;

import static utils.NumberTheory.isPrime;

/**
 * Brute force: test all polynomials
 */
public class Problem027 {
    private static final int MAX = 1000;

    public static void main(String[] args) {
        int max = 0, maxa = 0, maxb = 0;
        for (int a = -MAX + 1; a <= MAX - 1; a++) {
            for (int b = -MAX; b <= MAX; b++) {
                int n = 0;
                while (isPrime((long) n * n + (long) a * n + b)) {
                    n++;
                }
                if (n > max) {
                    maxa = a;
                    maxb = b;
                    max = n;
                }
            }
        }
        System.out.println(maxa * maxb);
    }
}
