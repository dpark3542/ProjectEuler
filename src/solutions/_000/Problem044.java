package solutions._000;

/**
 * Brute force: iterate on D.
 * For each D, iterate on P_j until the difference between P_(j+1) and P_j exceeds D, as all higher differences are greater than D.
 * For each P_j, test if P_k = P_j + D and P_j + P_k are pentagonal numbers.
 */
public class Problem044 {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            long d = pentagonal(i);
            for (int j = 1; j <= (d - 1) / 3; j++) {
                if (isPentagonal(pentagonal(j) + d) && isPentagonal(2 * pentagonal(j) + d)) {
                    System.out.println(d);
                    return;
                }
            }
            i++;
        }
    }

    private static long pentagonal(int n) {
        return n * (3L * n - 1) / 2;
    }

    private static boolean isPentagonal(long p) {
        double n = (Math.sqrt(24 * p + 1) + 1) / 6;
        return n == Math.floor(n);
    }
}
