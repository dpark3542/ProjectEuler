package solutions.java;

/**
 * Created by dpark3542 on 7/22/2017.
 */
public class Problem130 {
    // TODO: clean up code, add explanation
    public static void main(String[] args) {
        int n = 3, a, cnt = 0, sum = 0;
        while (cnt < 25) {
            n++;
            if (!isPrime(n) && gcd(n, 10) == 1) {
                if (gcd(n, 9) == 1) {
                    a = ord(n, 10);
                }
                else {
                    a = ord(9 * n, 10);
                }
                if ((n - 1) % a == 0) {
                    cnt++;
                    sum += n;
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int gcd(int x, int y) {
        while (y > 0) {
            int t = y;
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
