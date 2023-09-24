package solutions._000;

/**
 * Brute force: calculate the series.
 * Bignums are not needed if mods are taken properly.
 */
public class Problem048 {
    private static final long MOD = 10000000000L;

    public static void main(String[] args) {
        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            long p = 1;
            for (int j = 1; j <= i; j++) {
                p = (p * i) % MOD;
            }
            sum = (sum + p) % MOD;
        }
        System.out.println(sum);
    }
}
