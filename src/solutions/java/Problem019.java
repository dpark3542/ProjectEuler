package solutions.java;

public class Problem019 {
    /*
     * Implementation: cycle through each month's first day, keeping track of the total number of days mod 7 to
     * determine the day of the week.
     *
     * Alternatively, implement the Doomsday algorithm.
     */
    public static void main(String[] args) {
        // 0 denotes a Sunday
        int day = 2, ans = 0; // January 1, 1901 is a Tuesday
        for (int yr = 1901; yr <= 2000; yr++) {
            // leap year
            if (yr % 100 != 0 && yr % 4 == 0 || yr % 400 == 0) {
                for (int x : b) {
                    if (day == 0) {
                        ans++;
                    }
                    day = (day + x) % 7;
                }
            }
            // not a leap year
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
