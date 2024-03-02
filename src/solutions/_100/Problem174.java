package solutions._100;

public class Problem174 {
    private static final int n = 1000000;

    public static void main(String[] args) {
        int[] a = new int[n + 1];
        for (int i = 1; 4 * i * (i + 1) <= n; i++) {
            for (int j = 1; 4 * i * (i + j) <= n; j++) {
                a[4 * i * (i + j)]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (1 <= a[i] && a[i] <= 10) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
