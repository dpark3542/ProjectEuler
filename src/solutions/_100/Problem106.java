package solutions._100;

import java.math.BigInteger;

import static java.math.BigInteger.TWO;
import static java.math.BigInteger.ZERO;
import static utils.Miscellaneous.binomial;

/**
 * Given a satisfying pair of subsets of size $i$, there are $\frac{1}{2}\binom{2i}{i}-C_i$ ways their union can be ordered.
 * Multiply by the number of ways $\binom{n}{2i}$ to get $2i$ such elements.
 * Closed form answer is
 * \[\sum_{i=2}^{\lfloor n/2\rfloor}\dbinom{n}{2i}\left(\dbinom{2i}{i+1}-\dfrac{1}{2}\dbinom{2i}{i}\right).\]
 */
public class Problem106 {
    private static final int n = 12;

    public static void main(String[] args) {
        BigInteger ans = ZERO;
        for (int i = 2; 2 * i <= n; i++) {
            ans = ans.add(binomial(n, 2 * i).multiply(binomial(2 * i, i + 1).subtract(binomial(2 * i, i).divide(TWO))));
        }
        System.out.println(ans);
    }
}
