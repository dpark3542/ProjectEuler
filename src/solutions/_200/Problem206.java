package solutions._200;

/*
 * Brute force.
 * Go through all 10^9 possible combinations, 10 choices for each unknown digit.
 * This should be fast enough to run in a minute.
 *
 * A number of optimizations can be made.
 * Let n be the perfect square.
 * Last digit is 0, thus 10 | n. Since n is a perfect square, 100 | n in which the last two digits are 0.
 * Instead of brute forcing on all unknown digits, we can prune possible combinations for the last a digits.
 * Go through perfect squares up to 10^a and check if they are of the given form mod 10^a (if they share the same last a digits).
 * For example, a = 5 gives 30 combinations for the last 5 digits.
 * Then brute force on rest of digits.
 *
 * Only the first optimization was implemented below.
 *
 */
public class Problem206 {
    public static void main(String[] args) {
        for (int i = 0; i < Math.pow(10, 8); i++) {
            int j = i;
            long n = 10203040506070809L;
            for (long k = 10; j > 0; k *= 100) {
                n += k * (j % 10);
                j /= 10;
            }
            long sq = (long) Math.sqrt(n);
            if (n == sq * sq) {
                System.out.println(sq + "0");
                return;
            }
        }
    }
}
