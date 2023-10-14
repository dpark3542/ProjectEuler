package solutions._000;

/**
 * Prime factorization is well known. Trial division up to square root implemented below.
 */
public class Problem003 {
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
