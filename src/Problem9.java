/**
 * Created by dpark on 5/6/2017.
 */
public class Problem9 {
    public static void main(String[] args) {
        out:
        for (int c = 1; c < 1000; c++) {
            for (int b = (1000 - c) / 2; b < c; b++) {
                if ((1000 - b - c) * (1000 - b - c) + b * b == c * c) {
                    System.out.println((1000 - b - c) * b * c);
                    break out;
                }
            }
        }
    }
}
