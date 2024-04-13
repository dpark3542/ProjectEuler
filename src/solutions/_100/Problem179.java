package solutions._100;

public class Problem179 {
    private static final int n = 10000000;

    public static void main(String[] args) {
        int ans = 0;
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    int k = i, e = 0;
                    while (k % j == 0) {
                        k /= j;
                        e++;
                    }
                    a[i] = a[k] * (e + 1);
                    break;
                }
            }

            if (a[i] == 0) {
                a[i] = 2;
            }
            if (a[i] == a[i - 1]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
