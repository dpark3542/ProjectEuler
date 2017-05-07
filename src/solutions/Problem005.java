package solutions;

/**
 * Created by dpark on 5/6/2017.
 */
public class Problem005 {
    public static void main(String[] args) {
        long lcm = 1;
        for (int i = 2; i <= 20; i++) {
            lcm = lcm * i / gcd(lcm, i);
        }
        System.out.println(lcm);
    }

    private static long gcd(long x, long y) {
        while (y > 0) {
            long t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}
