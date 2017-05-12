package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpark on 5/11/2017.
 */
public class Problem023 {
    public static void main(String[] args){
        int n = 28123, sum = 0;
        boolean[] a = new boolean[n + 1];
        List<Integer> b = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (d(i) > i) {
                b.add(i);
            }
        }
        for (int x : b) {
            for (int y : b) {
                if (x + y <= n) {
                    a[x + y] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!a[i]) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static int d(int x) {
        if (x == 1) {
            return 0;
        }
        int s = 1;
        if (Math.sqrt(x) == Math.floor(Math.sqrt(x))) {
            s += Math.sqrt(x);
        }
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                s += i + x / i;
            }
        }
        return s;
    }
}
