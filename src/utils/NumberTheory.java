package utils;

import utils.structs.DistinctPriorityQueue;
import utils.structs.InfiniteIterator;
import utils.structs.Pair;
import utils.structs.Triple;

import java.math.BigInteger;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static java.lang.StrictMath.floorMod;
import static java.lang.StrictMath.sqrt;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static utils.ContinuedFraction.squareRootContinuedFraction;

public final class NumberTheory {
    private static final BigInteger PELL_BRUTE_FORCE_THRESHOLD = valueOf(10000000);

    /**
     * Returns if a number is prime using trial division.
     *
     * @param n integer to check
     * @return boolean if integer is prime
     */
    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int divisorCount(long x) {
        if (x == 1) {
            return 1;
        }
        int cnt = 2;
        long sq = (long) sqrt(x);
        if (x == sq * sq) {
            cnt++;
        }
        for (int i = 2; i < sqrt(x); i++) {
            if (x % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
    }

    /**
     * Returns gcd of two positive numbers using the Euclidean algorithm.
     *
     * @param a first number
     * @param b second number
     * @return gcd(a, b)
     */
    public static long gcd(long a, long b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException();
        }

        while (b > 0) {
            a %= b;
            long t = a;
            a = b;
            b = t;
        }

        return a;
    }

    /**
     * Returns Bezout coefficients (u, v) where au + bv = gcd(a, b) using the extended Euclidean algorithm.
     *
     * @param a first number
     * @param b second number
     * @return Bezout coefficients
     */
    public static Pair<Long, Long> bezout(long a, long b) {
        if (a <= 1 || b <= 1) {
            throw new IllegalArgumentException();
        }

        long rr = a, ss = 1, tt = 0, r = b, s = 0, t = 1;
        while (r != 0) {
            long rrr = rr, sss = ss, ttt = tt;
            rr = r;
            ss = s;
            tt = t;

            long q = rrr / rr;
            r = rrr % rr;
            s = sss - q * ss;
            t = ttt - q * tt;
        }

        return new Pair<>(ss, tt);
    }

    /**
     * Generates phi(i) from 1 <= i < n.
     *
     * @param n n
     * @return array of phi values
     */
    public static int[] phi(int n) {
        int[] phi = new int[n];
        phi[1] = 1;
        for (int i = 2; i < n; i++) {
            // calculate phi[i]
            // find a prime factor j of i
            for (int j = 2; j <= sqrt(i); j++) {
                int a = 1, b = i;
                while (b % j == 0) {
                    b /= j;
                    a *= j;
                }
                // if i divisible by j
                if (a != 1) {
                    // if i a power of j
                    if (b == 1) {
                        phi[i] = i - i / j;
                    }
                    // else, ab=i and a,b coprime
                    else {
                        phi[i] = phi[a] * phi[b];
                    }
                    break;
                }
            }
            // if i is prime
            if (phi[i] == 0) {
                phi[i] = i - 1;
            }
        }
        return phi;
    }

    /**
     * Computes n^e mod m using successive squaring.
     *
     * @param n base
     * @param e positive exponent
     * @param m modulus
     */
    public static long powerMod(long n, long e, long m) {
        if (e <= 0) {
            throw new IllegalArgumentException("Non-negative exponent");
        }
        if (m - 1 > sqrt(Long.MAX_VALUE)) {
            throw new IllegalArgumentException("Possible overflow error");
        }

        n %= m;
        if (n < 0) {
            n += m;
        }
        if (n == 0) {
            return 0;
        }

        long ans = 1;
        for (long pow = n; e > 0; pow = (pow * pow) % m, e >>= 1) {
            if ((e & 1) != 0) {
                ans = (ans * pow) % m;
            }
        }
        return ans;
    }

    /**
     * Returns p-adic valuation of n!.
     * v_p(n!) = \sum_{i=1}^\infty \lfloor n/p^i \rfloor
     *
     * @param p prime
     * @param n n
     * @return v_p(n!)
     */
    public static long legendre(long p, long n) {
        if (!isPrime(p)) {
            throw new IllegalArgumentException("Not prime");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Non-negative n");
        }

        long ans = 0;
        for (long x = p; x <= n; x *= p) {
            ans += n / x;
        }
        return ans;
    }

    /**
     * Given $x \cong a_i \pmod{n_i}$, returns the unique $x$ mod $\prod n_i$ as determined by the Chinese Remainder Theorem.
     *
     * @param a residues
     * @param n moduli
     * @return solution to system of congruences
     */
    public static long crt(List<Long> a, List<Long> n) {
        if (n.size() != a.size() || n.size() < 2) {
            throw new IllegalArgumentException();
        }
        // TODO: validate moduli are positive and pairwise coprime

        // TODO: don't combine in given order
        // TODO: handle overflow
        long m = n.getFirst(), x = a.getFirst();
        for (int i = 1; i < n.size(); i++) {
            Pair<Long, Long> p = bezout(m, n.get(i));
            x = x * p.second() * n.get(i) + a.get(i) * p.first() * m;
            m *= n.get(i);
            x %= m;
        }

        return floorMod(x, m);
    }

    public static List<Integer> toBase(long x, int base) {
        if (x < 0 || base < 2) {
            throw new IllegalArgumentException();
        }

        List<Integer> a = new ArrayList<>();
        while (x > 0) {
            a.add((int) x % base);
            x /= base;
        }
        return a;
    }

    public static long fromBase(List<Integer> a, int base) {
        long ans = 0;
        for (int x : a) {
            ans = ans * base + x;
        }
        return ans;
    }

    /**
     * Solves Pell equation x^2 - d * y^2 = n.
     * Based on a <a href="https://kconrad.math.uconn.edu/blurbs/ugradnumthy/pelleqn2.pdf">write up</a> by Keith Conrad.
     *
     * @param d d
     * @param n n
     * @return sorted, positive solutions to x^2 - d * y^2 = n.
     */
    public static Iterator<Pair<BigInteger, BigInteger>> pellSolve(int d, int n) {
        if (d <= 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return Collections.emptyIterator();
        }

        // Find u = a + b sqrt(d) such that a^2 - d * b^2 = 1.
        Iterator<Triple<BigInteger, BigInteger, BigInteger>> cf = squareRootContinuedFraction(valueOf(d));
        BigInteger a = ZERO, b = ZERO;
        while (!multiply(new Pair<>(a, b), new Pair<>(a, b.negate()), valueOf(d))
                .equals(new Pair<>(ONE, ZERO))) {
            Triple<BigInteger, BigInteger, BigInteger> t = cf.next();
            a = t.second();
            b = t.third();
        }
        final Pair<BigInteger, BigInteger> u = new Pair<>(a, b);

        // If n = 1, then all solutions are powers of u.
        if (n == 1) {
            return new InfiniteIterator<>() {
                private Pair<BigInteger, BigInteger> p = new Pair<>(ONE, ZERO);

                @Override
                public Pair<BigInteger, BigInteger> next() {
                    p = multiply(p, u, valueOf(d));
                    return p;
                }
            };
        }

        // Find all fundamental solutions (x', y') from Theorem 3.3.
        AbstractQueue<Pair<BigInteger, BigInteger>> fs = new DistinctPriorityQueue<>(Comparator.comparing(p -> p.second().abs()));
        BigInteger hi = a.add(b.multiply(ceilSquareRoot(valueOf(d))))
                         .sqrt()
                         .add(ONE)
                         .multiply(ceilSquareRoot(valueOf(Math.abs(n))))
                         .divide(TWO.multiply(valueOf(d).sqrt()));
        // Brute force if bound on |y'| from Theorem 3.3 is small. Otherwise, use a continued fraction.
        if (hi.compareTo(PELL_BRUTE_FORCE_THRESHOLD) < 0) {
            for (int y = 1; y <= hi.intValue(); y++) {
                long s = n + (long) d * y * y, x = (long) sqrt(s);
                if (x * x == s) {
                    fs.add(new Pair<>(valueOf(x), valueOf(y)));
                }
            }
        } else if (n * n >= d) {
            cf = squareRootContinuedFraction(valueOf(d));
            for (Triple<BigInteger, BigInteger, BigInteger> t = cf.next(); t.third()
                                                                            .compareTo(hi) <= 0; t = cf.next()) {
                BigInteger x = t.second(), y = t.third();
                if (x.multiply(x).subtract(valueOf(d).multiply(y).multiply(y)).equals(valueOf(n))) {
                    fs.add(new Pair<>(x, y));
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }

        if (fs.isEmpty()) {
            return Collections.emptyIterator();
        } else {
            return new InfiniteIterator<>() {
                @Override
                public Pair<BigInteger, BigInteger> next() {
                    Pair<BigInteger, BigInteger> ans = fs.poll();

                    List<Pair<BigInteger, BigInteger>> a = List.of(
                            multiply(ans, u, valueOf(d)),
                            multiply(ans, conjugate(u), valueOf(d)),
                            multiply(conjugate(ans), u, valueOf(d)),
                            multiply(conjugate(ans), conjugate(u), valueOf(d))
                    );

                    for (Pair<BigInteger, BigInteger> p : a) {
                        if (p.second().abs().compareTo(ans.second().abs()) > 0) {
                            fs.add(abs(p));
                        }
                    }

                    return ans;
                }
            };
        }
    }

    // TODO: refactor below to Miscellaneous
    private static BigInteger ceilSquareRoot(BigInteger x) {
        if (x.compareTo(ZERO) < 0) {
            throw new IllegalArgumentException();
        }

        BigInteger[] sqr = x.sqrtAndRemainder();
        if (sqr[1].equals(ZERO)) {
            return sqr[0];
        } else {
            return sqr[0].add(ONE);
        }
    }

    /**
     * Multiply p = a + b sqrt(D) by q = c + d sqrt(D) in Z[sqrt(D)].
     *
     * @param p a + b sqrt(D)
     * @param q c + d sqrt(D)
     * @return product in Z[sqrt(D)]
     */
    private static Pair<BigInteger, BigInteger> multiply(Pair<BigInteger, BigInteger> p, Pair<BigInteger, BigInteger> q, BigInteger d) {
        return new Pair<>(
                p.first().multiply(q.first()).add(d.multiply(p.second()).multiply(q.second())),
                p.first().multiply(q.second()).add(p.second().multiply(q.first()))
        );
    }

    /**
     * Conjugate a - b sqrt(D) of p = a + b sqrt(D) in Z[sqrt(D)].
     *
     * @param p a + b sqrt(D)
     * @return conjugate of p
     */
    private static Pair<BigInteger, BigInteger> conjugate(Pair<BigInteger, BigInteger> p) {
        return new Pair<>(p.first(), p.second().negate());
    }

    /**
     * Applies absolute value to each argument.
     *
     * @param p (a, b)
     * @return (|a|, |b|)
     */
    private static Pair<BigInteger, BigInteger> abs(Pair<BigInteger, BigInteger> p) {
        return new Pair<>(p.first().abs(), p.second().abs());
    }
}
