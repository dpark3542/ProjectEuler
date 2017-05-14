package solutions.java;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by dpark3542 on 5/11/2017.
 */
public class Problem024 {
    public static void main(String[] args) {
        int n = 1000000 - 1;
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            d.add(i);
        }
        int[] f = new int[10];
        f[0] = 1;
        for (int i = 1; i <= 9; i++) {
            f[i] = f[i - 1] * i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            sb.append(d.get(n / f[i]));
            d.remove(n / f[i]);
            n %= f[i];
        }
        System.out.println(sb);
    }
}
