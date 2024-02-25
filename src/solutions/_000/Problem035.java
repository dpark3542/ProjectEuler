package solutions._000;

import static java.lang.StrictMath.log10;
import static java.lang.StrictMath.pow;
import static utils.NumberTheory.isPrime;

/*
 * Brute force: test all numbers under one million.
 */
public class Problem035 {
    public static void main(String[] args) {
        int ans = 0;
        out: for (int i = 2; i < 1000000; i++) {
            int k = i;
            for (int j = 0; j <= log10(k); j++) {
                if (!isPrime(k)) {
                    continue out;
                }
                k = rotateRight(k);
            }
            ans++;
        }
        System.out.println(ans);
    }

    private static int rotateRight(int x) {
        return x / 10 + (x % 10) * (int) pow(10, (int) log10(x));
    }
}
