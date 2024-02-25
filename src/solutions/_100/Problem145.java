package solutions._100;

import static java.lang.Integer.parseInt;
import static utils.Miscellaneous.reverseString;

public class Problem145 {
    private static final int n = 1000000000;

    public static void main(String[] args) {
        int ans = 0;
        out: for (int i = 1; i < n; i++) {
            if (i % 10 == 0) {
                continue;
            }

            int j = parseInt(reverseString(Integer.toString(i)));

            for (int k = i + j; k > 0; k /= 10) {
                if ((k % 10) % 2 == 0) {
                    continue out;
                }
            }

            ans++;
        }

        System.out.println(ans);
    }
}
