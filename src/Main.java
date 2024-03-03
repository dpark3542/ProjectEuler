import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final int MOD = 1000000000;
    private static final String SOLUTIONS_FILE_PROPERTY = "solutionsFile";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final Pattern SOLUTION_PATTERN = Pattern.compile("(\\d+). (\\S+)");

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty(SOLUTIONS_FILE_PROPERTY)))) {
            boolean pass = true;
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                Matcher matcher = SOLUTION_PATTERN.matcher(line);
                if (matcher.find()) {
                    int id = Integer.parseInt(matcher.group(1));
                    String expectedAnswer = matcher.group(2);

                    try {
                        long startTime = System.nanoTime();
                        String actualAnswer = Checker.runProblem(id);
                        long endTime = System.nanoTime();

                        if (expectedAnswer.equals(actualAnswer)) {
                            print("Problem %d correct. Elapsed: %d.%09d s",
                                  ANSI_GREEN,
                                  id,
                                  (endTime - startTime) / MOD,
                                  (endTime - startTime) % MOD);
                        } else {
                            pass = false;
                            print("Problem %d incorrect. Expected: %s Actual: %s", ANSI_RED, id, expectedAnswer, actualAnswer);
                        }
                    } catch (UnsupportedOperationException e) {
                        print("Problem %d missing.", ANSI_YELLOW, id);
                    } catch (RuntimeException e) {
                        print("Problem %d failed to run.", ANSI_RED, id);
                    }
                }
            }

            if (pass) {
                print("All implemented problems correct.", ANSI_GREEN);
            } else {
                print("Some problems incorrect.", ANSI_RED);
                System.exit(1);
            }
        }
    }

    private static void print(String format, String color, Object... args) {
        System.out.println(color + String.format(format, args) + ANSI_RESET);
    }
}
