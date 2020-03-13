package solutions._000;

/*
 * Brute force
 *
 * Alternatively, the sum can be computed by hand using the well known formula 1 + 2 + ... + n = n(n+1)/2 and using
 * the principle of inclusion-exclusion.
 * Add all multiples of 3 and 5 and subtract all multiples of 15 as shown below.
 * S = (3 + 6 + ... + 999) + (5 + 10 + ... + 995) - (15 + 30 + ... + 990)
 *   = 3*333*334/2 + 5*199*200/2 - 15*66*67/2
 *   = 233168
 */
public class Problem001 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3  == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
