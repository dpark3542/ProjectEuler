package solutions.java;

public class Problem129 {
    public static void main(String[] args) {
        int lim = 1000000, n = lim + 1, a = ord(lim + 1, 10);
        while (a <= lim) {
            n++;
            if (gcd(n, 10) == 1) {
                if (gcd(n, 9) == 1) {
                    a = ord(n, 10);
                }
                else {
                    a = ord(9 * n, 10);
                }
            }
        }
        System.out.println(n);
    }

    private static long gcd(long x, long y) {
        while (y > 0) {
            long t = y;
            y = x % y;
            x = t;
        }
        return x;
    }

    private static int ord(int n, int a) {
        int x = 1, y = a % n;
        while (y != 1) {
            y = (y * a) % n;
            x++;
        }
        return x;
    }
}
