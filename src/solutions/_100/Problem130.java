package solutions._100;

import static utils.Utils.gcd;
import static utils.Utils.isPrime;

public class Problem130 {
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

    private static int ord(int n, int a) {
        int x = 1, y = a % n;
        while (y != 1) {
            y = (y * a) % n;
            x++;
        }
        return x;
    }
}
