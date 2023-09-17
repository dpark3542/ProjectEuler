package solutions._000;

/**
 * Brute force or disjoint set union
 */
public class Problem092 {
    public static void main(String[] args) {
        int n = 10000000, cnt = 0;
        boolean[] a = new boolean[n], mkd = new boolean[n];
        a[89] = true;
        mkd[1] = true;
        mkd[89] = true;
        for (int i = 2; i < n; i++) {
            int j = i;
            while (!mkd[j]) {
                int k = 0;
                while (j > 0) {
                    k += (j % 10) * (j % 10);
                    j /= 10;
                }
                j = k;
            }
            mkd[i] = true;
            if (a[j]) {
                a[i] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
