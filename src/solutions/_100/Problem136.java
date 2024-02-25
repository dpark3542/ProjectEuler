package solutions._100;

public class Problem136 {
    private static final int LIM = 50000000;

    public static void main(String[] args) {
        int[] cnt = new int[LIM];
        for (int a = 1; a < LIM; a++) {
            for (int d = a / 4 + 1; d < a; d++) {
                int n = 4 * a * d - a * a;
                if (n < LIM) {
                    cnt[n]++;
                }
                else {
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < LIM; i++) {
            if (cnt[i] == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
