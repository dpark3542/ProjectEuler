package solutions.java;

/*
 * Created by dpark3542 on 5/7/2017.
 */
public class Problem014 {
    /*
     * Brute force: find the length of the Collatz sequence of each number
     * Optimizations could be made in storing the length of the Collatz sequence of numbers.
     *
     */
    public static void main(String[] args) {
        int ans = 0;
        long max = 0;
        for (int i = 1; i < 1000000; i++) {
            int n = 1;
            for (long x = i; x > 1; x = collatz(x)) {
                n++;
            }
            if (max < n) {
                max = n;
                ans = i;
            }
        }
        System.out.println(ans);
    }

    private static long collatz(long x) {
        if (x % 2 == 0) {
            return x / 2;
        }
        return 3 * x + 1;
    }
}
