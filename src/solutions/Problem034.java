package solutions;

/**
 * Created by dpark on 5/13/2017.
 */
public class Problem034 {
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
