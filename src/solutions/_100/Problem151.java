package solutions._100;

import utils.structs.BigFraction;

public class Problem151 {
    private static final int n = 5;

    public static void main(String[] args) {
        int[] a = new int[n + 1];
        a[1] = 1;
        System.out.printf("%.6f\n", dfs(a).subtract(new BigFraction(2)).doubleValue());
    }

    private static BigFraction dfs(int[] a) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += a[i];
        }

        BigFraction ev = BigFraction.ZERO, offset = sum == 1 ? BigFraction.ONE : BigFraction.ZERO;
        for (int i = 1; i <= n; i++) {
            if (a[i] > 0) {
                int[] b = a.clone();
                b[i]--;
                for (int j = i + 1; j <= n; j++) {
                    b[j]++;
                }
                ev = ev.add(new BigFraction(a[i], sum).multiply(dfs(b).add(offset)));
            }
        }
        return ev;
    }
}
