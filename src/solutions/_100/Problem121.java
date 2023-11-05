package solutions._100;

public class Problem121 {
    private static final int n = 15;

    public static void main(String[] args) {
        long a = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (2 * Integer.bitCount(i) < n) {
                int x = 1;
                for (int j = 0, k = i; j < n && k > 0; j++, k >>= 1) {
                    if ((k & 1) == 1) {
                        x *= j + 1;
                    }
                }
                a += x;
            }
        }

        long b = 1;
        for (int i = 2; i <= n + 1; i++) {
            b *= i;
        }

        System.out.println((b - 1) / a);
    }
}
