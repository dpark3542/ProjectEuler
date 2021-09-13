package solutions._000;

public class Problem090 {
    private static boolean f(int a, int b) {
        return a == b || (a == 6 && b == 9) || (a == 9 && b == 6);
    }

    public static void main(String[] args) {
        int n = 210, m = 6;
        int[][] a = new int[n][m]; // all 6-combinations of {0, ..., 9}
        for (int i = 0; i < m; i++) {
            a[0][i] = i;
        }
        // generate combinations
        for (int i = 1; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (a[i - 1][j] < 10 - m + j) {
                    a[i][j] = a[i - 1][j] + 1;
                    for (int k = j + 1; k < m; k++) {
                        a[i][k] = a[i][k - 1] + 1;
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        a[i][k] = a[i - 1][k];
                    }
                    break;
                }
                else {
                    a[i][j] = a[i - 1][j];
                }
            }
        }
        // brute force
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean flag = true;
                for (int k = 1; k < 10; k++) {
                    int x = k * k / 10, y = k * k % 10;
                    boolean p = false, q = false, r = false, s = false;
                    for (int l = 0; l < m; l++) {
                        p |= f(a[i][l], x);
                        q |= f(a[i][l], y);
                        r |= f(a[j][l], x);
                        s |= f(a[j][l], y);
                    }
                    if (!(p && s) && !(q && r)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
