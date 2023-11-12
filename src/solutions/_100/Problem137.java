package solutions._100;

import utils.structs.Pair;

import java.math.BigInteger;
import java.util.Iterator;

import static utils.NumberTheory.pellSolve;

/**
 * Solve the generating function:
 * \begin{align*}
 *     A_F(x) &= F_1x + F_2x^2 + F_3x^3 + \cdots \\
 *     xA_F(x) &= \hphantom{F_1x +} F_1x^2 + F_2x^3 + \cdots \\
 *     (x+1)A_F(x) &= F_1x + F_3x^2 + F_4x^3 + \cdots \\
 *     &= F_1x + \dfrac{1}{x}A_F(x) - F_1 - F_2x\\
 *     A_F(x) &= -\dfrac{x}{x^2+x-1}
 * \end{align*}
 * Setting to a natural number $n$ yields
 * \[nx^2+(n+1)x-n=0.\]
 * If $n$ is a golden nugget, the discriminant $5n^2+2n+1$ must be a perfect square $m^2$.
 * \begin{align*}
 *     5n^2+2n+1&=m^2\\
 *     (5n+1)^2-5m^2&=-4
 * \end{align*}
 * This is a Pell equation.
 */
public class Problem137 {
    private static final int n = 15;

    public static void main(String[] args) {
        Iterator<Pair<BigInteger, BigInteger>> ps = pellSolve(5, -4);
        Pair<BigInteger, BigInteger> p = ps.next();
        int cnt = 0;
        while (cnt < n) {
            p = ps.next();
            if (p.first().mod(BigInteger.valueOf(5)).equals(BigInteger.ONE)) {
                cnt++;
            }
        }
        System.out.println(p.first().subtract(BigInteger.ONE).divide(BigInteger.valueOf(5)));
    }
}
