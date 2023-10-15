package solutions._000;

import static utils.NumberTheory.isPrime;

/**
 * Brute force: test each layer.
 * For n >= 2, the corners of the nth layer are:
 * 4n^2 - 4n + 1, 4n^2 - 6n + 3, 4n^2 - 8n + 5, 4n^2 - 10n + 7.
 * Notice the first corner is a perfect square, hence not prime.
 */
public class Problem058 {
    public static void main(String[] args) {
        int n = 2, cnt = 3;
        while (10 * cnt >= 4 * n - 3) {
            n++;
            if (isPrime(4L * n * n - 10L * n + 7)) {
                cnt++;
            }
            if (isPrime(4L * n * n - 8L * n + 5)) {
                cnt++;
            }
            if (isPrime(4L * n * n - 6L * n + 3)) {
                cnt++;
            }
        }
        System.out.println(2 * n - 1);
    }
}
