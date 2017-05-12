package solutions;

/**
 * Created by dpark on 5/11/2017.
 */
public class Problem030 {
    public static void main(String[] args) {
        int max = 10000000, tot = 0;
        for (int i = 10; i < max; i++) {
            int sum = 0;
            int j = i;
            while (j > 0) {
                sum += Math.pow(j % 10, 5);
                j /= 10;
            }
            if (i == sum) {
                tot += i;
            }
        }
        System.out.println(tot);
    }
}
