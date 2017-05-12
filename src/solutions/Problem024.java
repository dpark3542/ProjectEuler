package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpark on 5/11/2017.
 */
public class Problem024 {
    public static void main(String[] args) {
        int n = 1000000 - 1;
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            d.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            sb.append(d.get(n / factorial(i)));
            d.remove(n / factorial(i));
            n %= factorial(i);
        }
        System.out.println(sb);
    }

    private static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
