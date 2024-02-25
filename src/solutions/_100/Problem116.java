package solutions._100;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static utils.Miscellaneous.binomial;

public class Problem116 {
    private static final int n = 50;

    public static void main(String[] args) {
        BigInteger ans = ZERO;
        for (int i = 2; i <= 4; i++) {
            for (int j = 1; i * j <= n; j++) {
                ans = ans.add(binomial(n - i * j + j, j));
            }
        }
        System.out.println(ans);
    }
}
