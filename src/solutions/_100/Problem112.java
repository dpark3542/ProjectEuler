package solutions._100;

import java.util.ArrayList;
import java.util.List;

public class Problem112 {
    public static void main(String[] args) {
        int tot = 1, cnt = 1;
        while (cnt * 100 != tot) {
            List<Integer> a = new ArrayList<>();
            for (int i = tot + 1; i > 0; i /= 10) {
                a.add(i % 10);
            }

            boolean bouncy = false;
            int sign = 0;
            for (int i = 0; !bouncy && i < a.size() - 1; i++) {
                if (a.get(i) < a.get(i + 1)) {
                    if (sign == 1) {
                        bouncy = true;
                    }
                    sign = -1;
                } else if (a.get(i) > a.get(i + 1)) {
                    if (sign == -1) {
                        bouncy = true;
                    }
                    sign = 1;
                }
            }

            if (!bouncy) {
                cnt++;
            }
            tot++;
        }

        System.out.println(tot);
    }
}
