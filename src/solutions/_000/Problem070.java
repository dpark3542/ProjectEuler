package solutions._000;

import java.util.Arrays;

import static utils.NumberTheory.phi;

/*
 * Brute force: test all n.
 *
 */
public class Problem070 {
    public static void main(String[] args) {
        int n = 10000000;
        int[] phi = phi(n);
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
