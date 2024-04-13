package solutions._100;

public class Problem178 {
    private static final int n = 40, m = 10;

    public static void main(String[] args) {
        long[][] a = new long[n + 1][m], b = new long[n + 1][m], c = new long[n + 1][m], d = new long[n + 1][m];

        b[1][0] = 1;
        c[1][m - 1] = 1;
        for (int i = 1; i < m - 1; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            a[i][0] = a[i - 1][1] + c[i - 1][1];
            b[i][0] = b[i - 1][1] + d[i - 1][1];
            a[i][m - 1] = a[i - 1][m - 2] + b[i - 1][m - 2];
            c[i][m - 1] = c[i - 1][m - 2] + d[i - 1][m - 2];
            for (int j = 1; j < m - 1; j++) {
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j + 1];
                b[i][j] = b[i - 1][j - 1] + b[i - 1][j + 1];
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j + 1];
                d[i][j] = d[i - 1][j - 1] + d[i - 1][j + 1];
            }
        }

        long ans = 0;
        for (int i = m; i <= n; i++) {
            for (int j = 1; j < m; j ++) {
                ans += a[i][j];
            }
        }
        System.out.println(ans);
    }
}
