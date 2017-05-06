/**
 * Created by dpark on 5/6/2017.
 */
public class Problem2 {
    public static void main(String[] args) {
        int a = 1, b = 1, sum = 0;
        while (b <= 4000000) {
            if (b % 2 == 0) {
                sum += b;
            }
            int c = b;
            b = a + b;
            a = c;
        }
        System.out.println(sum);
    }
}
