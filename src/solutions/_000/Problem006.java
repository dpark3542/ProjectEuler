package solutions._000;

/**
 * Implementation.
 * Alternatively, compute the answer by hand using the following well known formulas:
 * 1^2 + 2^2 + ... + n^2 = n(n+1)(n+2)/6
 * 1 + 2 + ... + n = n(n+1)/2
 */
public class Problem006 {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 1; i <= 100; i++) {
            a += i * i;
        }
        int b = 0;
        for (int i = 1; i <= 100; i++) {
            b += i;
        }
        b = b * b;
        System.out.println(Math.abs(a - b));
    }
}
