package solutions._000;

public class Problem030 {
    /*
     * Brute force: test all numbers.
     * An upper bound of 10^6 can be established as all 7 digit numbers are greater than 7*9^5, the maximum possible sum
     * of the fifth powers of the digits.
     * This also holds true for numbers with more digits.
     */
    public static void main(String[] args) {
        int max = 1000000, tot = 0;
        for (int i = 10; i < max; i++) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += Math.pow(j % 10, 5);
            }
            if (i == sum) {
                tot += i;
            }
        }
        System.out.println(tot);
    }
}
