package solutions.java;

/*
 * Created by dpark3542 on 5/6/2017.
 */
public class Problem010 {
    /*
     * Brute force: test numbers for primality and sum them.
     *
     */
    public static void main(String[] args) {
        long sum = 0;
        out:
        for (int i = 2; i < 2000000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue out;
                }
            }
            sum += i;
        }
        System.out.println(sum);
    }
}
