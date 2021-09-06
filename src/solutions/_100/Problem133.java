package solutions._100;

import static utils.NumberTheory.isPrime;

public class Problem133 {
    public static void main(String[] args) {
        int sum = 2 + 3 + 5;
        out:
        for (int p = 7; p < 100000; p++) {
            if (!isPrime(p)) {
                continue;
            }
            int d = ord(p, 10);
            int v2 = v(2, p - 1), v5 = v(5, p - 1);
            int max = Math.max(v2, v5) - 1;
            int m = (p - 1) / (int) (Math.pow(2, v2) * Math.pow(5, v5));
            if (m != 1) {
                max += ord(m, 10);
            }
            else {
                max++;
            }
            int x = 1;
            for (int e = 1; e <= max; e++) {
                x = (x * 10) % (p - 1);
                if (x % d == 0) {
                    continue out;
                }
            }
            sum += p;
        }
        System.out.println(sum);
    }

    private static int v(int p, int n) {
        int x = 0;
        while (n % p == 0) {
            x++;
            n /= p;
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
