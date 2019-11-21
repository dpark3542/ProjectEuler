package solutions._000;

public class Problem058 {
    /*
     * Brute force: test each layer.
     * An optimization can be made in obtaining the formulas of each of the corners and realizing the bottom right
     * corner will always be a perfect square and thus not a prime.
     * For the nth layer of numbers around the center, the following closed-form expressions for the corners can be
     * derived for n >= 2:
     * 4n^2 - 4n + 1, 4n^2 - 6n + 3, 4n^2 - 8n + 5, 4n^2 - 10n + 7
     */
    public static void main(String[] args) {
        int n = 2, cnt = 3;
        while ((double) cnt / (4 * n - 3) >= 0.1) {
            n++;
            if (isPrime(4 * n * n - 10 * n + 7)) {
                cnt++;
            }
            if (isPrime(4 * n * n - 8 * n + 5)) {
                cnt++;
            }
            if (isPrime(4 * n * n - 6 * n + 3)) {
                cnt++;
            }
        }
        System.out.println(2 * n - 1);
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
