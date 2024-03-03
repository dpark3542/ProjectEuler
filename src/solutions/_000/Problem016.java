package solutions._000;

import static java.math.BigInteger.ONE;
import static utils.Miscellaneous.digitSum;

public class Problem016 {
    private static final int n = 1000;

    public static void main(String[] args) {
        System.out.println(digitSum(ONE.shiftLeft(n)));
    }
}
