/**
 * Created by dpark on 5/6/2017.
 */
public class Problem7 {
    public static void main(String[] args) {
        int pc = 0, p = 1;
        out:
        while (pc < 10001) {
            p++;
            for (int i = 2; i <= Math.sqrt(p); i++) {
                if (p % i == 0) {
                    continue out;
                }
            }
            pc++;
        }
        System.out.println(p);
    }
}
