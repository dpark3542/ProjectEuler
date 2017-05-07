package solutions;

/**
 * Created by dpark on 5/7/2017.
 */
public class Problem014 {
    public static void main(String[] args) {
        int ans = 0;
        long max = 0;
        for (int i = 1; i < 1000000; i++) {
            int n = 1;
            long x = i;
            while (x > 1) {
                x = collatz(x);
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
