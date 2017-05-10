package solutions;

/**
 * Created by dpark on 5/10/2017.
 */
public class Problem019 {
    public static void main(String[] args) {
        int day = 2, ans = 0; // January 1, 1901 is a Tuesday
        for (int yr = 1901; yr <= 2000; yr++) {
            if (yr % 100 != 0 && yr % 4 == 0 || yr % 400 == 0) {
                for (int x : b) {
                    if (day == 0) {
                        ans++;
                    }
                    day = (day + x) % 7;
                }
            }
            else {
                for (int x : a) {
                    if (day == 0) {
                        ans++;
                    }
                    day = (day + x) % 7;
                }
            }
        }
        System.out.println(ans);
    }

    private static int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] b = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
}
