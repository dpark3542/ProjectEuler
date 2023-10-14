package solutions._000;

import static utils.NumberTheory.isPrime;

/**
 * Testing primality is well known. Trial division up to square root implemented below.
 */
public class Problem007 {
    private static final int n = 10001;

    public static void main(String[] args) {
        int p = 2;
        for (int cnt = 0; cnt < n; p++) {
            if (isPrime(p)) {
                cnt++;
            }
        }
        System.out.println(p - 1);
    }
}
