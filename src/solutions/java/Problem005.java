package solutions.java;

public class Problem005 {
    /*
     * Compute lcm using ab = gcd(a,b)*lcm(a,b).
     * gcd is calculated using Euclidean algorithm.
     * Alternative methods to calculate gcd exist such as the binary GCD algorithm.
     * Java also implements gcd in the BigInteger class.
     */
    public static void main(String[] args) {
        long lcm = 1;
        for (int i = 2; i <= 20; i++) {
            lcm = lcm * i / gcd(lcm, i);
        }
        System.out.println(lcm);
    }

    private static long gcd(long x, long y) {
        while (y > 0) {
            long t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}
