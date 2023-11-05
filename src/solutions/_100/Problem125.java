package solutions._100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Miscellaneous.isPalindrome;

public class Problem125 {
    private static final int LIMIT = 100000000;
    public static void main(String[] args) {
        List<Long> a = new ArrayList<>();
        for (long i = 0, sum = 0; i * i < LIMIT; i++, sum += i * i) {
            a.add(sum);
        }

        Set<Long> s = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 2; j < a.size(); j++) {
                long x = a.get(j) - a.get(i);
                if (x < LIMIT && isPalindrome(x)) {
                    s.add(x);
                }
            }
        }

        long ans = 0;
        for (long x : s) {
            ans += x;
        }
        System.out.println(ans);
    }
}
