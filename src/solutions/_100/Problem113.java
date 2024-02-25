package solutions._100;

import static java.math.BigInteger.valueOf;
import static utils.Miscellaneous.binomial;

/**
 * \[\dbinom{n+9}{9}+\dbinom{n+10}{10}-10n-2\]
 */
public class Problem113 {
    private static final int n = 100;
    public static void main(String[] args) {
        System.out.println(binomial(n + 9, 9).add(binomial(n + 10, 10)).subtract(valueOf(10 * n + 2)));
    }
}
