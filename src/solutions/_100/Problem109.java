package solutions._100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem109 {
    private static final String D = "D";
    private static final String S25 = "S25";
    private static final String D25 = "D25";
    private static final List<String> PREFIXES = List.of("S", "D", "T");

    public static void main(String[] args) {
        List<String> a = new ArrayList<>(), b = new ArrayList<>();
        a.add(S25);
        a.add(D25);
        b.add(D25);
        for (int i = 1; i <= 20; i++) {
            for (String s : PREFIXES) {
                a.add(s + i);
            }
            b.add(D + i);
        }
        Collections.sort(a);

        int cnt = 0;
        for (String s : b) {
            if (value(s) < 100) {
                cnt++;
            }
            for (String t : a) {
                if (value(s) + value(t) < 100) {
                    cnt++;
                }
                for (String u : a) {
                    if (t.compareTo(u) > 0 ) {
                        continue;
                    }
                    if (value(s) + value(t) + value(u) < 100) {
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }

    private static int value(String s) {
        return (PREFIXES.indexOf(s.substring(0, 1)) + 1) * Integer.parseInt(s.substring(1));
    }
}
