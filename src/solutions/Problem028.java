package solutions;

/**
 * Created by dpark on 5/11/2017.
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
