package solutions._100;

import utils.structs.Pair;

import java.math.BigInteger;
import java.util.Iterator;

import static utils.NumberTheory.pellSolve;

public class Problem140 {
    private static final int n = 30;

    public static void main(String[] args) {
        Iterator<Pair<BigInteger, BigInteger>> ps = pellSolve(5, 44);
        Pair<BigInteger, BigInteger> p = ps.next();
        BigInteger ans = BigInteger.ZERO;
        int cnt = 0;
        while (cnt < n) {
            p = ps.next();
            if (p.first().mod(BigInteger.valueOf(5)).equals(BigInteger.TWO)) {
                ans = ans.add(p.first().subtract(BigInteger.valueOf(7)).divide(BigInteger.valueOf(5)));
                cnt++;
            }
        }
        System.out.println(ans);
    }
}
