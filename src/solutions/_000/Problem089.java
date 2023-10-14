package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p089_roman.txt"));
        int ans = 0;
        while (br.ready()) {
            String s = br.readLine();
            ans += s.length();
            s = s.replaceAll("IIII", "IV")
                 .replaceAll("XXXX", "XL")
                 .replaceAll("CCCC", "CD")
                 .replaceAll("VIV", "IX")
                 .replaceAll("LXL", "XC")
                 .replaceAll("DCD", "CM");
            ans -= s.length();
        }
        System.out.println(ans);
    }
}
