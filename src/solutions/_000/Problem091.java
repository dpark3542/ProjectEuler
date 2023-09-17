package solutions._000;

public class Problem091 {
    public static void main(String[] args) {
        int n = 50, cnt = 0;
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n; b++) {
                if (a == 0 && b == 0) {
                    continue;
                }
                for (int c = 0; c <= n; c++) {
                    for (int d = 0; d <= n; d++) {
                        if (c == 0 && d == 0) {
                            continue;
                        }
                        if (a == c && b == d) {
                            continue;
                        }
                        if (a * c + b * d == 0) {
                            cnt++;
                        }
                        else if (a * (c - a) + b * (d - b) == 0) {
                            cnt++;
                        }
                        else if (c * (c - a) + d * (d - b) == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt / 2);
    }
}
