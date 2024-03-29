package solutions._100;

import static utils.NumberTheory.isPrime;

public class Problem128 {
    public static void main(String[] args) {
        int cnt = 2, n = 3, lim = 2000;
        while (true) {
            if (isPrime(6 * n - 7) && isPrime(6 * n - 5) && isPrime(12 * n - 7)) {
                cnt++;
                if (cnt == lim) {
                    System.out.println((long) 3 * n * n - 9 * n + 8);
                    return;
                }
            }
            if (isPrime(6 * n - 7) && isPrime(6 * n - 1) && isPrime(12 * n - 19)) {
                cnt++;
                if (cnt == lim) {
                    System.out.println((long) 3 * n * n - 3 * n + 1);
                    return;
                }
            }
            n++;
        }
    }
}
