package solutions._100;

public class Problem117 {
    private static final int n = 50;

    public static void main(String[] args) {
        long[] a = new long[n + 1];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        a[3] = 4;
        for (int i = 4; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3] + a[i - 4];
        }
        System.out.println(a[n]);
    }
}
