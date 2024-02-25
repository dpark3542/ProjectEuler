package solutions._000;

/*
 * Brute force: calculate the period of the decimal representation of each fraction.
 * The period can be determined by calculating enough digits to recognize a pattern.
 * The period can be calculated an alternative way:
 * Notice that all unit fractions 1/d with repeating block n in its decimal representation are of the form n/99...9.
 * Furthermore, the period is equal to the number of digits in 99...9.
 * In other words, the period is ord_d(10) which can be easily brute forced by testing consecutive powers of 10.
 */
public class Problem026 {
    public static void main(String[] args) {
        int ans = 2, max = 1;
        for (int d = 2; d < 1000; d++) {
            if (d % 2 == 0 || d % 5 == 0) {
                continue;
            }
            int n = 1;
            for (int r = 10; r != 1; r = (10 * r) % d) {
                n++;
            }
            if (n > max) {
                ans = d;
                max = n;
            }
        }
        System.out.println(ans);
    }
}
