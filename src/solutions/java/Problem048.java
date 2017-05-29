package solutions.java;

/**
 * Created by dpark3542 on 5/28/2017.
 */
public class Problem048 {
    /*
     * Brute force: calculate the series.
     * Bignums are not needed if mods are properly taken.
     *
     */
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            long p = 1;
            for (int j = 1; j <= i; j++) {
                p = (p * i) % 10000000000L;
            }
            sum = (sum + p) % 10000000000L;
        }
        System.out.println(sum);
    }
}
