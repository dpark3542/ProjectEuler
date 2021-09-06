package solutions._300;

import java.util.ArrayList;
import java.util.List;

import static utils.NumberTheory.isPrime;

/*
 * Use dynamic programming to generate right truncatable Harshad numbers less than 10^13.
 * In particular, if x is a right truncatable Harshad numbers, find what Harshad numbers will truncate to x and store it.
 * Check which of the numbers are strong.
 * For each strong number, find what primes will truncate to that number.
 * Sum up these primes.
 *
 * Small optimizations could be made.
 * For example, similarly calculate digit sums with dynamic programming.
 *
 */
public class Problem387 {
    public static void main(String[] args) {
        long sum = 0;
        List<Long> a = new ArrayList<>();
        // initialize a, the list of right truncatable Harshad numbers
        for (long i = 1; i <= 9; i++) {
            a.add(i);
        }
        // find right truncatable Harshad numbers
        for (int i = 0; Math.log10(a.get(i)) < 12; i++) {
            int d = digitSum(a.get(i));
            for (int j = 0; j <= 9; j++) {
                long x = 10 * a.get(i) + j;
                if (x % (d + j) == 0) {
                    a.add(x);
                }
            }
        }
        // calculate sum
        for (long x : a) {
            // find strong right truncatable Harshad numbers
            if (isPrime(x / digitSum(x))) {
                // find strong right truncatable Harshad primes
                for (int j = 0; j <= 9; j++) {
                    if (isPrime(10 * x + j)) {
                        sum += 10 * x + j;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static int digitSum(long x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
