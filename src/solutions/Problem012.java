package solutions;

/**
 * Created by dpark on 5/7/2017.
 */
public class Problem012 {
    public static void main(String[] args) {
        int T = 1;
        for (int n = 1; divisorCount(T) <= 500; n++) {
            T = n * (n + 1) / 2;
        }
        System.out.println(T);
    }

    private static int divisorCount(int x) {
        int cnt = 0;
        if (Math.floor(Math.sqrt(x)) == Math.sqrt(x)) {
            cnt++;
        }
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
    }
}
