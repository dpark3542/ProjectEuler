package solutions.java;

/*
 * Created by dpark3542 on 5/13/2017.
 */
public class Problem035 {
    /*
     * Brute force: test all numbers under one million
     *
     */
    public static void main(String[] args) {
        int ans = 0;
        out:
        for (int i = 2; i < 1000000; i++) {
            int k = i;
            for (int j = 0; j < Integer.toString(i).length(); j++) {
                if (!isPrime(k)) {
                    continue out;
                }
                k = rotateRight(k);
            }
            ans++;
        }
        System.out.println(ans);
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

    private static int rotateRight(int x) {
        return x / 10 + (x % 10) * (int) Math.pow(10, Integer.toString(x).length() - 1);
    }
}
