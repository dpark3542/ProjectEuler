package solutions._100;

import static java.lang.Integer.parseInt;
import static utils.Miscellaneous.reverseString;

public class Problem145 {
    private static final int n = 1000000000;

    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1, p = 10; i < n / 10; i++) {
            if (i % 10 == 0) {
                if (i == p) {
                    p *= 10;
                }
                continue;
            }

            int j = parseInt(reverseString(Integer.toString(i)));
            for (int k = i % 2 == 0 ? 1 : 2; k < 10; k += 2) {
                out: for (int q = 1; p * q < n; q *= 10) {
                    for (int x = i + k * p * q + 10 * q * j + k; x > 0; x /= 10) {
                        if (x % 2 == 0) {
                            continue out;
                        }
                    }

                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
