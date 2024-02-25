package solutions._000;

import utils.structs.Triple;

import java.math.BigInteger;
import java.util.Iterator;

import static java.math.BigInteger.TWO;
import static utils.ContinuedFraction.squareRootContinuedFraction;

public class Problem057 {
    private static final int n = 1000;

    public static void main(String[] args) {
        int ans = 0;

        Iterator<Triple<BigInteger, BigInteger, BigInteger>> cf = squareRootContinuedFraction(TWO);
        for (int i = 0; i < n; i++) {
            Triple<BigInteger, BigInteger, BigInteger> t = cf.next();
            if (t.second().toString().length() > t.third().toString().length()) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
