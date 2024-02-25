package solutions._100;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.log10;
import static java.lang.StrictMath.pow;
import static utils.NumberTheory.isPrime;

public class Problem134 {
    public static void main(String[] args) {
        int p = 5;
        long sum = 0;
        while (p <= 1000000) {
            int q = p + 1;
            while (!isPrime(q)) {
                q++;
            }
            int i = (int) pow(10, floor(log10(p)) + 1);
            sum += (long) (((q - p) * modInverse(i % q, q)) % q) * i + p;
            p = q;
        }
        System.out.println(sum);
    }


    private static int modInverse(int a, int n) {
        int t = 0, nt = 1, r = n, nr = a;
        while (nr != 0) {
            int q = r / nr, tmp;
            tmp = t;
            t = nt;
            nt = tmp - q * nt;
            tmp = r;
            r = nr;
            nr = tmp - q * nr;
        }
        return t < 0 ? t + n : t;
    }
}
