package solutions;

/**
 * Created by dpark on 5/6/2017.
 */
public class Problem006 {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 1; i <= 100; i++) {
            a += i * i;
        }
        int b = 0;
        for (int i = 1; i <= 100; i++) {
            b += i;
        }
        b = b * b;
        System.out.println(Math.abs(a - b));
    }
}
