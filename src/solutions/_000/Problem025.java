package solutions._000;

public class Problem025 {
    /*
     * Brute force: use BigNum addition to test every fibonacci number until the number contains 1000 digits.
     *
     * Binet's formula:
     * F_n = 1/sqrt(5) * ((1+sqrt(5))/2)^n - 1/sqrt(5) * ((1-sqrt(5))/2)^n
     * Notice the second term decreases and tends towards zero as n increases. Thus, for large n, the second term is
     * effectively zero.
     * Knowing that 10^999 is the smallest 1000 digit number, solving F_n >= 10^999 yields,
     * n >= (999 + log(5)/2) / log((1+sqrt(5))/2)
     * The value on the right hand side can calculated.
     */
    public static void main(String[] args) {
        System.out.println((int) Math.ceil((999 + Math.log10(5) / 2) / Math.log10((1 + Math.sqrt(5)) / 2)));
    }
}
