package solutions._000;

/**
 * Test all numbers up to 10^6.
 * Beyond 6 digits, the maximum possible sum of fifth digit powers is too small.
 */
public class Problem030 {
    private static final int MAX = 1000000;

    public static void main(String[] args) {
        int tot = 0;
        for (int i = 10; i < MAX; i++) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += (j % 10) * (j % 10) * (j % 10) * (j % 10) * (j % 10);
            }
            if (i == sum) {
                tot += i;
            }
        }
        System.out.println(tot);
    }
}
