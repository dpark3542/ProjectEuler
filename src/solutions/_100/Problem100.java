package solutions._100;

/**
 * Let there be x blue balls and y total balls.
 * The probability is x(x-1)/(y(y-1)) = 1/2.
 * This is the Pell's equation u^2 - 2v^2 = -1 with the change of variables u = 2y-1 and v = 2x-1.
 * The fundamental solution is trivially (u,v) = (1,1).
 * Then all solutions (u,v) satisfy (1+sqrt(2))^k = u + v * sqrt(2) for some k.
 * Iterate on k until u = 2y-1 > 2 * 10^12 + 1.
 *
 * We can also get a close lower bound on k:
 * Summing (1+sqrt(2))^k and (1-sqrt(2))^k cancels all the non-integral terms in the expansion.
 * Hence, u = ((1+sqrt(2))^k + (1-sqrt(2))^k) / 2.
 * Solving (1+sqrt(2))^k > u > 2 * 10^12 + 1 yields a lower bound.
 * Since (1-sqrt(2))^k vanishes as k grows, this lower bound is a good approximation.
 */
public class Problem100 {
    public static void main(String[] args) {
        long u = 1, v = 1;
        while (u - 1 <= 2e12) {
            long a = u, b = v;
            u = a + 2 * b;
            v = a + b;
        }
        System.out.println((v + 1) / 2);
    }
}
