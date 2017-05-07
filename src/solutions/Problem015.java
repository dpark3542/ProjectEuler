package solutions;

import java.math.BigInteger;

/**
 * Created by dpark on 5/7/2017.
 */
public class Problem015 {
    public static void main(String[] args) {
        BigInteger ans = BigInteger.ONE;
        for (int i = 40; i > 20; i--) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        for (int i = 20; i > 0; i--) {
            ans = ans.divide(BigInteger.valueOf(i));
        }
        System.out.println(ans);
    }
}
