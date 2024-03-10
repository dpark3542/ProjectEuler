package solutions._100;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static java.math.BigInteger.valueOf;

/**
 * Principle of inclusion-exclusion with three sets: numbers without 1, numbers without A, and numbers without a non-leading zero.
 */
public class Problem162 {
    private static final int b = 16, n = 16;

    public static void main(String[] args) {
        System.out.println(valueOf(b).pow(n)
                                     .subtract(valueOf(b - 1).pow(n).multiply(TWO)) // |A| + |B|
                                     .subtract(valueOf(b - 1).pow(n + 1).subtract(ONE).divide(valueOf(b - 2))) // |C|
                                     .add(valueOf(b - 2).pow(n)) // |A \cup B|
                                     .add(valueOf(b - 2).pow(n + 1).subtract(ONE).divide(valueOf(b - 3)).multiply(TWO)) // |A \cup C| + |B \cup C|
                                     .subtract(valueOf(b - 3).pow(n + 1).subtract(ONE).divide(valueOf(b - 4))) // |A \cup B \cup C|
                                     .toString(b)
                                     .toUpperCase());
    }
}
