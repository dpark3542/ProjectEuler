package solutions.java;

public class Problem027 {
    /*
     * Brute force: test all polynomials
     */
    public static void main(String[] args) {
        int max = 0, maxa = 0, maxb = 0;
        for (int a = -999; a <= 999; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int n = 0;
                while (isPrime(n * n + a * n + b)) {
                    n++;
                }
                if (n > max) {
                    maxa = a;
                    maxb = b;
                    max = n;
                }
            }
        }
        System.out.println(maxa * maxb);
    }

    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
