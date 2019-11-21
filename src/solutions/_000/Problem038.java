package solutions._000;

public class Problem038 {
    /*
     * Brute force: test each number for a pandigital product and take the largest product.
     * An upper bound of 10000 can be established as any 5-digit or higher digit number will have over 9 digits in its
     * pandigital product.
     */
    public static void main(String[] args) {
        int n = 10000, max = 0;
        out:
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; sb.length() < 9; j++) {
                sb.append(j * i);
            }
            if (sb.length() > 9) {
                continue;
            }
            boolean[] mkd = new boolean[10];
            mkd[0] = true;
            for (int x = Integer.parseInt(sb.toString()); x > 0; x /= 10) {
                if (mkd[x % 10]) {
                    continue out;
                }
                mkd[x % 10] = true;
            }
            max = Math.max(max, Integer.parseInt(sb.toString()));
        }
        System.out.println(max);
    }
}
