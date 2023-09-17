import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public final class Checker {
    private static final String PROBLEM_CLASS_NAME_FORMAT = "solutions._%d00.Problem%03d";
    private static final String MAIN_METHOD_NAME = "main";
    private static final String PROJECT_EULER_URL_FORMAT = "https://projecteuler.info/problem=%d";
    private static final String BODY_FORMAT = "answer_%d=%s&captcha=";
    private static final String SET_COOKIE_HEADER = "set-cookie";
    private static final String COOKIE_HEADER = "Cookie";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded";
    private static final String CONTENT_LENGTH_HEADER = "Content-Length";
    private static final String CORRECT_ANSWER_PROMPT_FORMAT = "Congratulations, the answer you gave to problem %d is correct.";
    private static final String WRONG_ANSWER_PROMPT = "Sorry, but the answer you gave appears to be incorrect.";

    /**
     * Runs program for a given problem.
     *
     * @param id problem number
     * @return output of program
     */
    public static String runProblem(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Problem id must be positive");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stdout = System.out;

        try (PrintStream printStream = new PrintStream(outputStream)) {
            Class<?> problem = Class.forName(String.format(PROBLEM_CLASS_NAME_FORMAT, id / 100, id));

            System.setOut(printStream);
            problem.getMethod(MAIN_METHOD_NAME, String[].class).invoke(null, (Object) null);

            return Objects.requireNonNull(outputStream.toString()).strip();
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException("Problem not implemented");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.setOut(stdout);
        }
    }

    /**
     * Checks answer with the static Project Euler website.
     *
     * @param id problem number
     * @param answer answer
     * @return boolean if answer is correct
     */
    public static boolean checkAnswer(int id, String answer) {
        if (id < 1) {
            throw new IllegalArgumentException("Problem id must be positive");
        }

        try {
            URL url = new URL(String.format(PROJECT_EULER_URL_FORMAT, id));

            URLConnection cookieConnection = url.openConnection();
            cookieConnection.setDoOutput(false);
            System.out.println(cookieConnection.getHeaderFields().get(SET_COOKIE_HEADER));
            String cookie = cookieConnection.getHeaderFields().get(SET_COOKIE_HEADER).get(0).split(";")[0];

            URLConnection answerConnection = url.openConnection();
            answerConnection.setDoOutput(true);
            answerConnection.setRequestProperty(COOKIE_HEADER, cookie);
            answerConnection.setRequestProperty(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE);

            byte[] body = String.format(BODY_FORMAT, id, answer).getBytes(StandardCharsets.UTF_8);
            answerConnection.setRequestProperty(CONTENT_LENGTH_HEADER, Integer.toString(body.length));
            answerConnection.getOutputStream().write(body);

            String correctAnswerPrompt = String.format(CORRECT_ANSWER_PROMPT_FORMAT, id);
            BufferedReader br = new BufferedReader(new InputStreamReader(answerConnection.getInputStream()));
            for (String line = ""; line != null; line = br.readLine()) {
                if (line.contains(correctAnswerPrompt)) {
                    return true;
                } else if (line.contains(WRONG_ANSWER_PROMPT)) {
                    return false;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("Could not determine from response if correct or wrong");
    }
}
