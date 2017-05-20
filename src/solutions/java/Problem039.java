package solutions.java;

/*
 * Created by dpark3542 on 5/13/2017.
 */
public class Problem039 {
    /*
     * Brute force: loop through all possible a, b with integer c = sqrt(a^2 + b^2). Increment the number of solutions to the perimeter a + b + c if c is integer.
     *
     * Alternatively, transform a^2 + b^2 = c^2 = (p - a - b)^2 to (a - p)(b - p) = p^2/2 using Simon's Favorite Factoring Trick.
     * Because a > 0 and, without loss of generality, b >= a, the number of right triangles with perimeter p is equal to the number of divisors of p^2/2 between p/sqrt(2) and p.
     * Brute force to find the number of solutions for each perimeter.
     *
     */
    public static void main(String[] args) {
        int[] cnt = new int[1001];
        for (int a = 1; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                if (Math.floor(Math.sqrt(a * a + b * b)) == Math.sqrt(a * a + b * b) && a + b + Math.sqrt(a * a + b * b) <= 1000) {
                    cnt[a + b + (int) Math.sqrt(a * a + b * b)]++;
                }
            }
        }
        int maxP = 0, maxSol = 0;
        for (int p = 1; p <= 1000; p++) {
            if (maxSol < cnt[p]) {
                maxP = p;
                maxSol = cnt[p];
            }
        }
        System.out.println(maxP);
    }
}
