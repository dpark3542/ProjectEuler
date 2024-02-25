package solutions._000;

import static java.lang.StrictMath.sqrt;

/**
 * Brute force: loop through all possible a, b with integer c = sqrt(a^2 + b^2). Increment the number of solutions
 * to the perimeter a + b + c if c is integer.
 * Alternatively, reduce a^2 + b^2 = c^2 = (p - a - b)^2 to (a - p)(b - p) = p^2/2.
 * Because a > 0 and, without loss of generality, b >= a, the number of right triangles with perimeter p is equal to
 * the number of divisors of p^2/2 between p/sqrt(2) and p.
 * Brute force to find the number of solutions for each perimeter.
 */
public class Problem039 {
    private static final int n = 1000;

    public static void main(String[] args) {
        int[] cnt = new int[n + 1];
        for (int a = 1; a < n; a++) {
            for (int b = a; b < n; b++) {
                int c = (int) sqrt(a * a + b * b);
                if (a + b + c <= n && c * c == a * a + b * b) {
                    cnt[a + b + c]++;
                }
            }
        }
        int maxP = 0, maxSol = 0;
        for (int p = 1; p <= n; p++) {
            if (maxSol < cnt[p]) {
                maxP = p;
                maxSol = cnt[p];
            }
        }
        System.out.println(maxP);
    }
}
