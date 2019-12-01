package solutions._000;

import static utils.Utils.isPrime;

/*
 * Brute force: test all polynomials
 *
 */
public class Problem027 {
    public static void main(String[] args) {
        int max = 0, maxa = 0, maxb = 0;
        for (int a = -999; a <= 999; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int n = 0;
                while (isPrime(n * n + a * n + b)) {
                    n++;
                }
                if (n > max) {
                    maxa = a;
                    maxb = b;
                    max = n;
                }
            }
        }
        System.out.println(maxa * maxb);
    }
}
