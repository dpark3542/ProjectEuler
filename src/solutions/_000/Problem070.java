package solutions._000;

import java.util.Arrays;

/*
 * Brute force: test all n.
 * The Euler totient function phi can be calculated using dynamic programming since phi is multiplicative.
 *
 */
public class Problem070 {
    public static void main(String[] args) {
        // calculate phi
        int n = 10000000;
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
        // find minimum ratio i/phi(i)
        int ans = 2; // n that gives minimum ratio
        double r = 2; // minimum ratio
        for (int i = 2; i < n; i++) {
            double s = (double) i / phi[i]; // s = i/phi(i)
            if (r > s) {
                // check if i and phi(i) are permutations
                char[] a = Integer.toString(i).toCharArray(), b = Integer.toString(phi[i]).toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                if (Arrays.equals(a, b)) {
                    r = s;
                    ans = i;
                }
            }
        }
        System.out.println(ans);
    }
}
