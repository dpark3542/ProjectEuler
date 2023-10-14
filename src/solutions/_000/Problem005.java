package solutions._000;

import static utils.NumberTheory.gcd;

/**
 * Compute lcm using ab = gcd(a,b)*lcm(a,b).
 */
public class Problem005 {
    public static void main(String[] args) {
        long lcm = 1;
        for (int i = 2; i <= 20; i++) {
            lcm = lcm * i / gcd(lcm, i);
        }
        System.out.println(lcm);
    }
}
