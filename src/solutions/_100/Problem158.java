package solutions._100;

/*
 * p(n) = (26 choose n) * (2^n - n - 1)
 */
public class Problem158 {
    public static void main(String[] args) {
        int n = 26;
        int[][] p = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            p[i][0] = 1;
            p[i][i] = 1;
            for (int j = 1; j < i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, (long) p[n][i] * ((1 << i) - i - 1));
        }
        System.out.println(ans);
    }
}
