package solutions.java;

/*
 * Created by dpark3542 on 5/13/2017.
 */
public class Problem039 {
    public static void main(String[] args) {
        int ans = 0, maxsol = 0;
        for (int p = 0; p <= 1000; p += 2) {
            int x = p * p / 2, sol = 0;
            for (int i = 2; i < Math.sqrt(x); i++) {
                if (x % i == 0 && p / Math.sqrt(2) < x / i && x / i < p) {
                    sol++;
                }
            }
            if (sol > maxsol) {
                ans = p;
                maxsol = sol;
            }
        }
        System.out.println(ans);
    }
}
