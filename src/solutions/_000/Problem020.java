package solutions._000;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import static utils.Miscellaneous.digitSum;

/**
 * Bignum multiplication:
 * Compute successive factorials.
 * For each factorial, multiply each digit by the next number and carry over to get the next factorial.
 * Alternate factorial computation algorithms exist such as prime factorization.
 * Bignum operations are already implemented in Java's BigInteger class.
 */
public class Problem020 {
    private static final int n = 100;

    public static void main(String[] args) {
        BigInteger x = ONE;
        for (int i = 2; i < n; i++) {
            x = x.multiply(valueOf(i));
        }
        System.out.println(digitSum(x));
    }
}
