package solutions.java;

/*
 * Created by dpark3542 on 5/11/2017.
 */
public class Problem030 {
    public static void main(String[] args) {
        int max = 10000000, tot = 0;
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
