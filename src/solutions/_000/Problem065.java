package solutions._000;

import java.math.BigInteger;

import static utils.Miscellaneous.digitSum;

public class Problem065 {
    public static void main(String[] args) {
        BigInteger prev = BigInteger.TWO, cur = BigInteger.valueOf(3);
        for (int i = 2; i < 100; i++) {
            BigInteger p = prev;
            prev = cur;
            cur = cur.multiply(BigInteger.valueOf(i % 3 == 2 ? 2 * (i + 1) / 3 : 1)).add(p);
        }
        System.out.println(digitSum(cur));
    }
}
