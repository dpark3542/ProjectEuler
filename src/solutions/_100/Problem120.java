package solutions._100;

public class Problem120 {
    public static void main(String[] args) {
        int ans = 0;
        for (int a = 3; a <= 1000; a++) {
            if (a % 2 == 0) {
                ans += (a - 2) * a;
            } else {
                ans += (a - 1) * a;
            }
        }
        System.out.println(ans);
    }
}
