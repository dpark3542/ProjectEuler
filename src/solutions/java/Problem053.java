package solutions.java;

public class Problem053 {
    /*
     * Brute force: test all combinations.
     * A Bignum class is not needed if the loop for each row terminates at the first value greater than a million.
     */
    public static void main(String[] args) {
        int cnt = 0;
        for (int n = 1; n <= 100; n++) {
            int C = 1;
            for (int r = 0; r <= n / 2; r++) {
                if (C > 1000000) {
                    cnt += n + 1 - 2 * r;
                    break;
                }
                C = C * (n - r) / (r + 1);
            }
        }
        System.out.println(cnt);
    }
}
