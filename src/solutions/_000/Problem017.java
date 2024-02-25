package solutions._000;

import java.util.Map;

import static java.util.Map.entry;

/**
 * Implementation: convert every number to words.
 */
public class Problem017 {
    private static final String HUNDRED = " hundred ", AND = "and ";
    private static final Map<Integer, String> MAP = Map.ofEntries(
            entry(1, "one"),
            entry(2, "two"),
            entry(3, "three"),
            entry(4, "four"),
            entry(5, "five"),
            entry(6, "six"),
            entry(7, "seven"),
            entry(8, "eight"),
            entry(9, "nine"),
            entry(10, "ten"),
            entry(11, "eleven"),
            entry(12, "twelve"),
            entry(13, "thirteen"),
            entry(14, "fourteen"),
            entry(15, "fifteen"),
            entry(16, "sixteen"),
            entry(17, "seventeen"),
            entry(18, "eighteen"),
            entry(19, "nineteen"),
            entry(20, "twenty"),
            entry(30, "thirty"),
            entry(40, "forty"),
            entry(50, "fifty"),
            entry(60, "sixty"),
            entry(70, "seventy"),
            entry(80, "eighty"),
            entry(90, "ninety"),
            entry(1000, "one thousand")
    );
    public static void main(String[] args) {
        int tot = 0;
        for (int i = 1; i <= 1000; i++) {
            String s = convert(i);
            for (char c : s.toCharArray()) {
                if (c != ' ' && c != '-') {
                    tot++;
                }
            }
        }
        System.out.println(tot);
    }

    private static String convert(int x) {
        if (MAP.containsKey(x)) {
            return MAP.get(x);
        }
        StringBuilder sb = new StringBuilder();
        if (x >= 100) {
            sb.append(MAP.get(x / 100))
              .append(HUNDRED);
            if (x % 100 != 0) {
                sb.append(AND);
            }
        }
        if (MAP.containsKey(x % 100)) {
            sb.append(MAP.get(x % 100));
        }
        else if (x % 100 != 0) {
            sb.append(MAP.get(x % 100 - x % 10))
              .append('-')
              .append(MAP.get(x % 10));
        }
        return sb.toString();
    }
}
