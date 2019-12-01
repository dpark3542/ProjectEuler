package solutions._000;

/*
 * Brute force: determine if each number is amicable by d(d(n)) = n.
 * d can be calculated using prime factorization algorithms.
 *
 */
public class Problem021 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            int j = d(i);
            if (j > 0 && i != j && d(j) == i) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static int d(int x) {
        if (x == 1) {
            return 0;
        }
        int s = 1, sq = (int) Math.sqrt(x);
        if (x == sq * sq) {
            s += sq;
        }
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                s += i + x / i;
            }
        }
        return s;
    }
}
