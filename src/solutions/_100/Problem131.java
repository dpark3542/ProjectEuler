package solutions._100;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.sqrt;
import static utils.NumberTheory.isPrime;

public class Problem131 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 2; i < 1000000; i++) {
            if (isPrime(i)) {
                double j = (sqrt(12 * i - 3) - 3) / 6;
                if (j == floor(j)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
