package solutions._100;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

public class Problem104 {
    private static final int MOD = 1000000000;
    public static void main(String[] args) {
        int prevMod = 1, curMod = 1;
        BigInteger prev = ONE, cur = ONE;
        for (int k = 3; ; k++) {
            BigInteger tmp = cur;
            cur = cur.add(prev);
            prev = tmp;

            int tmpMod = curMod;
            curMod = (prevMod + curMod) % MOD;
            prevMod = tmpMod;

            if (isPandigital(Integer.toString(curMod)) && isPandigital(cur.toString().substring(0, 9))) {
                System.out.println(k);
                break;
            }
        }
    }

    private static boolean isPandigital(String s) {
        boolean[] mkd = new boolean[10];
        int cnt = 0;
        for (char c : s.toCharArray()) {
            int i = c - '0';
            if (i == 0) {
                return false;
            } else if (mkd[i]) {
                return false;
            } else {
                mkd[i] = true;
                cnt++;
            }
        }
        return cnt == 9;
    }
}
