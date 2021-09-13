package solutions._000;

import java.util.ArrayList;
import java.util.List;

public class Problem087 {
    public static void main(String[] args) {
        int n = 50000000;
        boolean[] mkd = new boolean[n];
        List<Integer> pr = new ArrayList<>();
        for (int i = 2; i * i < n; i++) {
            boolean flag = false;
            for (int p : pr) {
                if (i % p == 0) {
                    flag = true;
                    break;
                }
                if (p * p > i) {
                    break;
                }
            }
            if (!flag) {
                pr.add(i);
            }
        }
        for (int p : pr) {
            for (int q : pr) {
                if (p * p + q * q * q >= n) {
                    break;
                }
                for (int r : pr) {
                    int t = p * p + q * q * q + r * r * r * r;
                    if (t < n) {
                        mkd[t] = true;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (mkd[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
