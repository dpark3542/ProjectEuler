package solutions.java;

/*
 * Created by dpark3542 on 5/6/2017.
 */
public class Problem003 {
    /*
     * Prime factorization by trial division.
     * Alternative prime factorization methods exist such as Pollard's rho algorithm.
     *
     */
    public static void main(String[] args) {
        long x = 600851475143L, d = 2;
        while (d <= Math.sqrt(x)) {
            if (x % d == 0) {
                x /= d;
            }
            else {
                d++;
            }
        }
        System.out.println(x);
    }
}
