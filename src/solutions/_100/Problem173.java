package solutions._100;

public class Problem173 {
    private static final int n = 1000000;

    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; 4 * i * (i + 1) <= n; i++) {
            ans += n / (4 * i) - i;
        }
        System.out.println(ans);
    }
}
