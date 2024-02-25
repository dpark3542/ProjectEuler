package solutions._000;

import static java.lang.Integer.parseInt;
import static java.lang.StrictMath.max;

/*
 * Brute force: test each number for a pandigital product and take the largest product.
 * An upper bound of 10000 can be established as any 5-digit or higher digit number will have over 9 digits in its
 * pandigital product.
 */
public class Problem038 {
    private static final int n = 10000;
    public static void main(String[] args) {
        int max = 0;
        out: for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; sb.length() < 9; j++) {
                sb.append(j * i);
            }
            if (sb.length() > 9) {
                continue;
            }
            boolean[] mkd = new boolean[10];
            mkd[0] = true;
            for (int x = parseInt(sb.toString()); x > 0; x /= 10) {
                if (mkd[x % 10]) {
                    continue out;
                }
                mkd[x % 10] = true;
            }
            max = max(max, parseInt(sb.toString()));
        }
        System.out.println(max);
    }
}
