package solutions._100;

import static utils.Utils.isPrime;

public class Problem132 {
    public static void main(String[] args) {
        int cnt = 0, sum = 0;
        for (int n = 7; cnt < 40; n++) {
            if (!isPrime(n)) {
                continue;
            }
            int e = 1000000000 % (n - 1), x = 1;
            for (int i = 0; i < e; i++) {
                x = (10 * x) % n;
            }
            if (x == 1) {
                cnt++;
                sum += n;
            }
        }
        System.out.println(sum);
    }
}
