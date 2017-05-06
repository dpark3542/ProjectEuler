/**
 * Created by dpark on 5/6/2017.
 */
public class Problem3 {
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
