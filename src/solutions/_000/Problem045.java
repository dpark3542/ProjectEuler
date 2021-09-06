package solutions._000;

public class Problem045 {
    /*
     * Brute force: test if each hexagonal number is also a triangular and pentagonal number.
     * An optimization made be made in noticing that all hexagonal numbers are triangular numbers.
     */
    public static void main(String[] args) {
        long b = 144;
        for (double a = 166.2; a != Math.floor(a); b++) {
            a = (Math.sqrt(24L * (b + 1) * (2 * b + 1) + 1) + 1) / 6;
        }
        System.out.println(b * (2 * b - 1));
    }
}
