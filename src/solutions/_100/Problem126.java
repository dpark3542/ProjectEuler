package solutions._100;

public class Problem126 {
    private static final int c = 1000;
    private static final int MIN = 3792;

    public static void main(String[] args) {
        int i = MIN;
        while (h(i) != c) {
            i++;
        }
        System.out.println(i);
    }

    private static int h(int n) {
        if (n % 2 == 1) {
            return 0;
        }
        int cnt = 0;
        for (int t = 1; 4 * t * t <= n - 2; t++) {
            cnt += f(n / 2 + t * t - 1, t);
        }
        return cnt;
    }


    private static int f(int n, int m) {
        int cnt = 0;
        for (int x = m; x <= (n - 1) / 2; x++) {
            for (int d = 2 * x; d * d <= n + x * x; d++) {
                if ((n + x * x) % d == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
