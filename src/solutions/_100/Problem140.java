package solutions._100;

import utils.structs.Pair;

import java.math.BigInteger;
import java.util.Iterator;

import static java.math.BigInteger.TWO;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static utils.NumberTheory.pellSolve;

public class Problem140 {
    private static final int n = 30;

    public static void main(String[] args) {
        Iterator<Pair<BigInteger, BigInteger>> ps = pellSolve(5, 44);
        Pair<BigInteger, BigInteger> p = ps.next();
        BigInteger ans = ZERO;
        int cnt = 0;
        while (cnt < n) {
            p = ps.next();
            if (p.first().mod(valueOf(5)).equals(TWO)) {
                ans = ans.add(p.first().subtract(valueOf(7)).divide(valueOf(5)));
                cnt++;
            }
        }
        System.out.println(ans);
    }
}
