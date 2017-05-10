package solutions;

import java.math.BigInteger;

/**
 * Created by dpark on 5/10/2017.
 */
public class Problem020 {
    public static void main(String[] args) {
        BigInteger n = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }
        int ans = 0;
        String s = n.toString();
        for (int i = 0; i < s.length(); i++) {
            ans += Integer.parseInt(s.substring(i, i + 1));
        }
        System.out.println(ans);
    }
}
