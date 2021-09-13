package utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class NumberTheory {
    /**
     * Returns if a number is prime using trial division.
     * There exist many other well-known primality tests which are more efficient.
     * Storing primes up to some limit and using binary search may be more efficient.
     * (May implement this in the future and store primes in a text file somewhere.)
     * Often times trial division is fast and simplistic enough to justify being used.
     *
     * @param n integer to check
     * @return boolean if integer is prime
     */
    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns gcd of two positive numbers using the Euclidean algorithm.
     * There exist other algorithms which are more efficient.
     * Java's BigInteger class also implements gcd.
     * The Euclidean algorithm is simplistic and usually fast enough.
     *
     * @param x first number
     * @param y second number
     * @return gcd of the two numbers
     */
    public static long gcd(long x, long y) {
        while (y > 0) {
            long t = y;
            y = x % y;
            x = t;
        }
        return x;
    }

    /**
     * Generates phi(i) from 1 <= i < n.
     * Phi is multiplicative hence the use of dynamic programming.
     * @param n
     * @return array of phi values
     */
    public static int[] phi(int n) {
        int[] phi = new int[n];
        phi[1] = 1;
        for (int i = 2; i < n; i++) {
            // calculate phi[i]
            // find a prime factor j of i
            for (int j = 2; j <= Math.sqrt(i); j++) {
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

    public static class BigFraction extends Number implements Comparable<BigFraction> {
        private final boolean sign; // true if nonnegative
        private final BigInteger n, d;

        public static final BigFraction ZERO = new BigFraction(0, 1);
        public static final BigFraction ONE = new BigFraction(1, 1);

        private BigFraction(BigInteger a, BigInteger b, boolean sign) {
            n = a;
            d = b;
            this.sign = sign;
        }

        public BigFraction(BigInteger a, BigInteger b) {
            if (b.compareTo(BigInteger.ZERO) == 0) {
                throw new ArithmeticException("Division by zero");
            }
            sign = a.compareTo(BigInteger.ZERO) == 0 || a.compareTo(BigInteger.ZERO) * b.compareTo(BigInteger.ZERO) > 0;
            BigInteger g = a.gcd(b);
            n = a.divide(g).abs();
            d = b.divide(g).abs();
        }

        public BigFraction(long a, long b) {
            this(BigInteger.valueOf(a), BigInteger.valueOf(b));
        }

        public BigFraction add(BigFraction f) {
            BigInteger a = sign ? n : n.negate(), c = f.sign ? f.n : f.n.negate();
            return new BigFraction(a.multiply(f.d).add(c.multiply(d)), d.multiply(f.d));
        }

        public BigFraction multiply(BigFraction f) {
            BigInteger g = n.gcd(f.d), h = f.n.gcd(d);
            boolean newSign = sign == f.sign || n.compareTo(BigInteger.ZERO) == 0 || f.n.compareTo(BigInteger.ZERO) == 0;
            return new BigFraction(n.divide(g).multiply(f.n.divide(h)), d.divide(h).multiply(f.d.divide(g)), newSign);
        }

        public BigFraction negate() {
            if (n.compareTo(BigInteger.ZERO) == 0) {
                return this;
            }
            return new BigFraction(n, d, !sign);
        }

        public BigFraction inverse() {
            return new BigFraction(d, n, sign);
        }

        @Override
        public int intValue() {
            int value = n.divide(d).intValue();
            return sign ? value : -value;
        }

        @Override
        public long longValue() {
            long value = n.divide(d).longValue();
            return sign ? value : -value;
        }

        @Override
        public float floatValue() {
            float value = new BigDecimal(n).divide(new BigDecimal(d), MathContext.DECIMAL32).floatValue();
            return sign ? value : -value;
        }

        @Override
        public double doubleValue() {
            double value = new BigDecimal(n).divide(new BigDecimal(d), MathContext.DECIMAL32).doubleValue();
            return sign ? value : -value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            else if (!(obj instanceof BigFraction)) {
                return false;
            }
            BigFraction f = (BigFraction) obj;
            return n.equals(f.n) && d.equals(f.d) && sign == f.sign;
        }

        @Override
        public int compareTo(BigFraction o) {
            if (sign && !o.sign) {
                return 1;
            }
            if (!sign && o.sign) {
                return -1;
            }
            int c = n.multiply(o.d).compareTo(o.n.multiply(d));
            return sign ? c : -c;
        }

        @Override
        public int hashCode() {
            return n.hashCode() * 31 + d.hashCode();
        }

        @Override
        public String toString() {
            if (sign) {
                return n.toString() + '/' + d.toString();
            }
            return '-' + n.toString() + '/' + d.toString();
        }
    }
}
