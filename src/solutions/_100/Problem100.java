package solutions._100;

import utils.structs.Pair;

import java.math.BigInteger;
import java.util.Iterator;

import static utils.NumberTheory.pellSolve;

/**
 * Let there be x blue balls and y total balls.
 * The probability is x(x-1)/(y(y-1)) = 1/2.
 * This is the Pell equation u^2 - 2v^2 = -1 with the change of variables u = 2y-1 and v = 2x-1.
 */
public class Problem100 {
    private static final long LIMIT = 1000000000000L;

    public static void main(String[] args) {
        Iterator<Pair<BigInteger, BigInteger>> ps = pellSolve(2, -1);
        BigInteger u = BigInteger.ZERO, v = BigInteger.ZERO;
        while (!(u.mod(BigInteger.TWO).equals(BigInteger.ONE) && u.compareTo(BigInteger.valueOf(2 * LIMIT - 1)) > 0)) {
            Pair<BigInteger, BigInteger> p = ps.next();
            u = p.first();
            v = p.second();
        }
        System.out.println(v.add(BigInteger.ONE).divide(BigInteger.TWO));
    }
}
