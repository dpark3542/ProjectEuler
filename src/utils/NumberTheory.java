package utils;

public class NumberTheory {
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
        long sq = (long) Math.sqrt(x);
        if (x == sq * sq) {
            cnt++;
        }
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
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
     * @param n n
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
        if (m - 1 > Math.sqrt(Long.MAX_VALUE)) {
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
}
