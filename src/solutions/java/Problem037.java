package solutions.java;

/*
 * Created by dpark3542 on 5/13/2017.
 */
public class Problem037 {
    public static void main(String[] args) {
        int sum = 0, cnt = 0;
        out:
        for (int p = 10; cnt < 11; p++) {
            for (int q = p; q > 0; q /= 10) {
                if (!isPrime(q)) {
                    continue out;
                }
            }
            for (int q = p; q > 0; q %= Math.pow(10, (int) Math.log10(q))) {
                if (!isPrime(q)) {
                    continue out;
                }
            }
            sum += p;
            cnt++;
        }
        System.out.println(sum);
    }

    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
