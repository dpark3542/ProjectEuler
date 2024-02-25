package solutions._000;

/*
 * Brute force: create the spiral and sum all numbers.
 *
 * Alternative solution: find a closed-form expression for the sum of an n x n spiral.
 * For the nth layer of numbers around the center, the following closed-form expressions for the corners can be
 * derived for n >= 2:
 * 4n^2 - 4n + 1, 4n^2 - 6n + 3, 4n^2 - 8n + 5, 4n^2 - 10n + 7
 * By summation, the closed-form expression for the sum of an n x n spiral is
 * (4n^3 + 3n^2 + 8n - 9)/6
 */
public class Problem028 {
    public static void main(String[] args) {
        int sum = 1, cur = 1;
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 4; j++) {
                cur += 2 * i + 2;
                sum += cur;
            }
        }
        System.out.println(sum);
    }
}
