package solutions._000;

public class Problem085 {
    public static void main(String[] args) {
        int d = 1, area = 2000000;
        while (true) {
            if (area - d > 0) {
                if (f(area - d)) {
                    return;
                }
            }
            if (f(area + d)) {
                return;
            }
            d++;
        }
    }

    private static boolean f(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if ((n) % i == 0) {
                int d1 = 8 * i + 1, d2 = 8 * n / i + 1;
                int sq1 = (int) Math.sqrt(d1), sq2 = (int) Math.sqrt(d2);
                if (sq1 * sq1 == d1 && sq2 * sq2 == d2) {
                    System.out.println((sq1 - 1) * (sq2 - 1) / 4);
                    return true;
                }
            }
        }
        return false;
    }
}
