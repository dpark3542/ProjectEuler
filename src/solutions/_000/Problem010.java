package solutions._000;

public class Problem010 {
    /*
     * Brute force: test numbers for primality and sum them.
     * Many algorithms exist for testing primality.
     */
    public static void main(String[] args) {
        long sum = 0;
        out:
        for (int i = 2; i < 2000000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue out;
                }
            }
            sum += i;
        }
        System.out.println(sum);
    }
}
