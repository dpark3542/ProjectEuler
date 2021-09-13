package solutions._000;

public class Problem086 {
    public static void main(String[] args) {
        int m = 0, cnt = 0;
        while (cnt < 1000000) {
            m++;
            for (int a = 1; a <= m; a++) {
                for (int b = a; b <= m; b++) {
                    int d = (a + b) * (a + b) + m * m, sq = (int) Math.sqrt(d);
                    if (sq * sq == d) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(m);
    }
}
