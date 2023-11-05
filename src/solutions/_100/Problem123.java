package solutions._100;

import static utils.NumberTheory.isPrime;

/**
 * For even $n$, $(p_n-1)^n+(p_n+1)^n\cong 2 \pmod{p_n^2}$.
 * For odd $n$, $(p_n-1)^n+(p_n+1)^n\cong 2np_n \pmod{p_n^2}$.
 */
public class Problem123 {
    private static final long LIMIT = 10000000000L;

    public static void main(String[] args) {
        int n = 0;
        long p = 2;
        while (true) {
            if (isPrime(p)) {
                n++;
                if (n % 2 == 1 && (2 * n * p) % (p * p) > LIMIT) {
                    System.out.println(n);
                    return;
                }
            }
            p++;
        }
    }
}
