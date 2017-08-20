package solutions.java;

public class Problem012 {
    /*
     * Brute force: compute the number of divisors of each triangle number
     * Number of divisors are computed using a prime factorization algorithm.
     */
    public static void main(String[] args) {
        int T = 1;
        for (int n = 1; divisorCount(T) <= 500; n++) {
            T = n * (n + 1) / 2;
        }
        System.out.println(T);
    }

    private static int divisorCount(int x) {
        int cnt = 0;
        if (Math.sqrt(x) == Math.floor(Math.sqrt(x))) {
            cnt++;
        }
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
    }
}
