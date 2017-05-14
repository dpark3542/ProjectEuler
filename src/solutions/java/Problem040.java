package solutions.java;

/*
 * Created by dpark3542 on 5/13/2017.
 */
public class Problem040 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; sb.length() < 1000000; i++) {
            sb.append(i);
        }
        int prod = 1;
        for (int i = 1; i <= 1000000; i *= 10) {
            prod *= Integer.parseInt(sb.substring(i - 1, i));
        }
        System.out.println(prod);
    }
}
