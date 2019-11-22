package solutions._100;

/**
 * Coefficients are multinomial coefficients C(n, x, y, z) = n! / (x!y!z!) with x + y + z = n.
 * Let v_p(n) be the p-adic valuation of n.
 * Then c = C(n, x, y, z) is a multiple of 10^12 if and only if
 * v_2(c) - v_2(x) - v_2(y) - v_2(z) >= 12
 * v_5(c) - v_5(x) - v_5(y) - v_5(z) >= 12
 * are both true.
 * Brute force each unique triple (x, y, z) for this condition. Account for permutations of (x, y, z) when totalling.
 *
 */
public class Problem154 {
    public static void main(String[] args) {
        int n = 200000, ans = 0;
        int[] v2 = new int[n + 1], v5 = new int[n + 1];;
        // compute v_2(i!) and v_5(i!) for i <= n
        // set up v_2 and v_5 for dp
        for (int i = 2; i <= n; i *= 2) {
            for (int j = i; j <= n; j += i) {
                v2[j]++;
            }
        }
        for (int i = 5; i <= n; i *= 5) {
            for (int j = i; j <= n; j += i) {
                v5[j]++;
            }
        }
        // accumulate v_2 and v_5
        for (int i = 1; i <= n; i++) {
            v2[i] += v2[i - 1];
            v5[i] += v5[i - 1];
        }
        // iterate through x, y and test condition
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= x; y++) {
                int z = n - x - y;
                if (z < 0) {
                    break;
                }
                else if (z <= y && v5[n] - v5[x] - v5[y] - v5[z] >= 12 && v2[n] - v2[x] - v2[y] - v2[z] >= 12) {
                    if (x == z) {
                        ans++;
                    }
                    else if (x == y) {
                        ans += 3;
                    }
                    else if (y == z) {
                        ans += 3;
                    }
                    else {
                        ans += 6;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
