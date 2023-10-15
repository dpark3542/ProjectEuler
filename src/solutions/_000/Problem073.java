package solutions._000;

import static utils.NumberTheory.gcd;

/**
 * Brute force.
 */
public class Problem073 {
    public static void main(String[] args) {
        int n = 12000, ans = 0;
        for (int b = 4; b <= 12000; b++) {
            for (int a = (int) java.lang.Math.ceil(b / 3.0); 2 * a < b; a++) {
                if (gcd(a, b) == 1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
