package solutions._100;

import utils.structs.Pair;

import java.math.BigInteger;
import java.util.Iterator;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static utils.NumberTheory.pellSolve;

public class Problem138 {
    private static final int n = 12;

    public static void main(String[] args) {
        Iterator<Pair<BigInteger, BigInteger>> ps = pellSolve(20, -4);
        Pair<BigInteger, BigInteger> p = ps.next();
        BigInteger ans = ZERO;
        int cnt = 0;
        while (cnt < n) {
            p = ps.next();
            int r = p.first().mod(valueOf(5)).intValue();
            if (r == 1 || r == 4) {
                ans = ans.add(p.second());
                cnt++;
            }
        }
        System.out.println(ans);
    }
}
