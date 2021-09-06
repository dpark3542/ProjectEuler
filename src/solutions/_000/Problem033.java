package solutions._000;

import static utils.NumberTheory.gcd;

/*
 * Brute force: test all fractions.
 *
 */
public class Problem033 {
    public static void main(String[] args) {
        int n = 1, d = 1;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    if (10*b + c < 10*a + b && 10*a*b + a*c == 10*a*c + b*c) {
                        n *= 10*b + c;
                        d *= 10*a + b;
                    }
                    if (10*a + b < 10*b + c && 10*a*c + b*c == 10*a*b + a*c) {
                        n *= 10*a + b;
                        d *= 10*b + c;
                    }
                }
            }
        }
        System.out.println(d / gcd(n, d));
    }
}
