package solutions._100;

/*
 * Multinomial coefficients mod p can be computed with Kummer's theorem.
 * Can be computed faster in O(1) if p-adic valuations of factorials are precomputed.
 */
public class Problem154 {
    public static void main(String[] args) {
        int n = 200000, ans = 0;
        int[] v2 = new int[n + 1], v5 = new int[n + 1];
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
        for (int i = 1; i <= n; i++) {
            v2[i] += v2[i - 1];
            v5[i] += v5[i - 1];
        }
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
