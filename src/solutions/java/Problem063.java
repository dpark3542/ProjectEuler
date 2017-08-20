package solutions.java;

/**
 * Created by dpark3542 on 7/21/2017.
 */
public class Problem063 {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += Math.floor(1 / (1 - Math.log10(i)));
        }
        System.out.println(ans);
    }
}
