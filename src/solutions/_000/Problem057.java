package solutions._000;

public class Problem057 {
    /*
     * Brute force: test every expansion.
     * An optimization can be made in noticing n/d becomes (n+2d)/(n+d) after one iteration.
     * Bignums are necessary for this approach.
     *
     * Alternative solution: Notice that both the numerator and denominator have recursive formulas,
     * a_n = 2a_(n-1) + a_(n-2)
     * Solving this linear recurrence for the initial terms gives,
     * numerator = (1.5+sqrt(2)) * (1+sqrt(2))^n + (1.5-sqrt(2)) * (1-sqrt(2))^n
     * denominator = (1+0.75sqrt(2)) * (1+sqrt(2))^n + (1-0.75sqrt(2)) * (1-sqrt(2))^n
     * Notice the second term of each formula decreases and tends towards zero as n increases. Testing the first few
     * terms confirms the second term is effectively zero.
     * It is left to compare the floors of both expressions to compare the number of digits.
     */
    public static void main(String[] args) {
        int cnt = 0;
        double a = Math.log10(1 + Math.sqrt(2)), b = Math.log10(1.5 + Math.sqrt(2)), c = Math.log10(1 + 0.75 * Math.sqrt(2));
        for (int n = 0; n < 1000; n++) {
            if (Math.floor(b + n * a) > Math.floor(c + n * a)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
