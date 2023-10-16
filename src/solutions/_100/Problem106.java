package solutions._100;

/**
 * Given a satisfying pair of subsets of size $i$, there are $\frac{1}{2}\binom{2i}{i}-C_i$ ways their union can be ordered.
 * Multiply by the number of ways $\binom{n}{2i}$ to get $2i$ such elements.
 * Closed form answer is
 * \[\sum_{i=2}^{\lfloor n/2\rfloor}\dbinom{n}{2i}\left(\dbinom{2i}{i+1}-\dfrac{1}{2}\dbinom{2i}{i}\right).\]
 */
public class Problem106 {
    private static final int n = 12;

    public static void main(String[] args) {
        int ans = 0;
        for (int i = 2; 2 * i <= n; i++) {
            ans += binomial(n, 2 * i) * (binomial(2 * i, i + 1) - binomial(2 * i, i) / 2);
        }
        System.out.println(ans);
    }

    private static int binomial(int a, int b) {
        int ans = 1;
        for (int i = b + 1; i <= a; i++) {
            ans *= i;
        }
        for (int i = 2; i <= a - b; i++) {
            ans /= i;
        }
        return ans;
    }
}
