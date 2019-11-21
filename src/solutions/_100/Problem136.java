package solutions._100;

public class Problem136 {
    public static void main(String[] args) {
        int lim = 50000000;
        int[] cnt = new int[lim];
        for (int a = 1; a < lim; a++) {
            for (int d = a / 4 + 1; d < a; d++) {
                int n = 4 * a * d - a * a;
                if (n < lim) {
                    cnt[n]++;
                }
                else {
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < lim; i++) {
            if (cnt[i] == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
