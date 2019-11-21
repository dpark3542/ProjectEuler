package solutions._000;

public class Problem034 {
    /*
     * Brute force: test all numbers.
     * An upper bound of 10^7 can be established because all 7-digit numbers are greater than 7*9! the maximum sum of
     * the factorials.
     * This also holds true for numbers with more digits.
     */
    public static void main(String[] args) {
        int[] f = new int[10];
        f[0] = 1;
        for (int i = 1; i <= 9; i++) {
            f[i] = f[i - 1] * i;
        }
        int tot = 0;
        for (int i = 10; i < 10000000; i++) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += f[j % 10];
            }
            if (i == sum) {
                tot += i;
            }
        }
        System.out.println(tot);
    }
}
