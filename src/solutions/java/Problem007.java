package solutions.java;

/*
 * Created by dpark3542 on 5/6/2017.
 */
public class Problem007 {
    /*
     * Brute force: test numbers for primality using trial division.
     * Alternative primality tests exist such as Miller-Rabin.
     * Java implements a primality test in the BigInteger class.
     *
     */
    public static void main(String[] args) {
        int cnt = 0, p = 1;
        out:
        while (cnt < 10001) {
            p++;
            for (int i = 2; i <= Math.sqrt(p); i++) {
                if (p % i == 0) {
                    continue out;
                }
            }
            cnt++;
        }
        System.out.println(p);
    }
}
