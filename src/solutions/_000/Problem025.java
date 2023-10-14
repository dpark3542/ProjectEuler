package solutions._000;

/**
 * Brute force: use BigNum addition to test every fibonacci number until the number contains 1000 digits.
 * Alternatively, apply Binet's formula:
 * F_n = 1/sqrt(5) * ((1+sqrt(5))/2)^n - 1/sqrt(5) * ((1-sqrt(5))/2)^n
 * The second term vanishes as n increases. Compute the lower bound n >= (999 + log(5)/2) / log((1+sqrt(5))/2).
 */
public class Problem025 {
    public static void main(String[] args) {
        System.out.println((int) Math.ceil((999 + Math.log10(5) / 2) / Math.log10((1 + Math.sqrt(5)) / 2)));
    }
}
