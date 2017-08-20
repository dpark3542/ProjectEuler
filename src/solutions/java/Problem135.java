package solutions.java;

/**
 * Created by dpark3542 on 7/23/2017.
 */
public class Problem135 {
    // TODO: clean up code, add explanation
    public static void main(String[] args) {
        int lim = 1000000;
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
            if (cnt[i] == 10) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
