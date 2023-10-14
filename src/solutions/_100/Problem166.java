package solutions._100;

/**
 * Brute force. Grids with the same row, column, and diagonal sums can be uniquely determined by 9 entries $a_0,\ldots,a_9$:
 * \[\begin{bmatrix}
 *     a_0 & p & a_1 & a_2\\
 *     w & a_3 & q & a_4\\
 *     x & a_5 & a_6 & r\\
 *     a_7 & y & z & a_8
 * \end{bmatrix}\]
 */
public class Problem166 {
    private static final int n = (int) Math.pow(10, 9);
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] a = new int[10];
            for (int j = 0, k = i; k > 0; j++, k /= 10) {
                a[j] = k % 10;
            }
            int s = a[0] + a[3] + a[6] + a[8];

            int p = s - a[0] - a[1] - a[2];
            if (p < 0 || p >= 10) {
                continue;
            }

            int q = s - a[2] - a[5] - a[7];
            if (q < 0 || q >= 10) {
                continue;
            }

            int r = s - a[2] - a[4] - a[8];
            if (r < 0 || r >= 10) {
                continue;
            }

            int w = s - a[3] - q - a[4];
            if (w < 0 || w >= 10) {
                continue;
            }

            int x = s - a[5] - a[6] - r;
            if (x < 0 || x >= 10) {
                continue;
            }

            if (a[0] + w + x + a[7] != s) {
                continue;
            }

            int y = s - p - a[3] - a[5];
            if (y < 0 || y >= 10) {
                continue;
            }

            int z = s - a[1] - q - a[6];
            if (z < 0 || z >= 10) {
                continue;
            }

            if (a[7] + y + z + a[8] != s) {
                continue;
            }

            ans++;
        }
        System.out.println(ans);
    }
}
