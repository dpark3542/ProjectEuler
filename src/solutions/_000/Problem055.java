package solutions._000;

import java.math.BigInteger;

import static utils.Miscellaneous.reverseString;

/**
 * Brute force: test each number.
 * Bignums are necessary.
 */
public class Problem055 {
    public static void main(String[] args) {
        int cnt = 0;
        out:
        for (int i = 1; i < 10000; i++) {
            BigInteger x = BigInteger.valueOf(i);
            for (int j = 1; j < 50; j++) {
                x = x.add(new BigInteger(reverseString(x.toString())));
                if (x.toString().equals(reverseString(x.toString()))) {
                    continue out;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
