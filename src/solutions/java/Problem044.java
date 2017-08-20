package solutions.java;

public class Problem044 {
    /*
     * Brute force: loop through every possible pentagonal number D.
     * For every D, test all P_j if P_k = P_j + D and if P_j + P_k are pentagonal numbers.
     * It is sufficient to test all P_j until the difference between P_(j+1) and P_j exceeds D, as all higher
     * differences are greater than D.
     * This rigorously tests if difference D is possible before moving on to higher differences.
     */
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            long d = P(i);
            for (int j = 1; j <= (d - 1) / 3; j++) {
                if (isP(P(j) + d) && isP(2 * P(j) + d)) {
                    System.out.println(d);
                    return;
                }
            }
            i++;
        }
    }

    private static long P(int n) {
        return n * (3 * n - 1) / 2;
    }

    private static boolean isP(long p) {
        double n = (Math.sqrt(24 * p + 1) + 1) / 6;
        return n == Math.floor(n);
    }
}
