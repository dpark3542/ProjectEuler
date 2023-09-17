import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.nio.charset.StandardCharsets;

public final class Checker {
    /**
     * Runs program for a given problem.
     *
     * @param id problem number
     * @return output of program
     */
    public static String run(int id) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream), stdout = System.out;
        String className = "solutions._" + (id / 100) + "00.Problem" + String.format("%03d", id), result = null;
        try {
            Class<?> problem = Class.forName(className);
            Method main = problem.getMethod("main", String[].class);

            // run program
            System.setOut(printStream);
            main.invoke(null, (Object) null);
            System.setOut(stdout);

            result = outputStream.toString();
        }
        catch (Exception e) {
            System.setOut(stdout);
            e.printStackTrace();
        }
        finally {
            printStream.close();
        }
        if (result == null) {
            throw new RuntimeException("No answer found.");
        }
        return result.strip();
    }

    /**
     * Checks answer with the static Project Euler website.
     *
     * @param id problem number
     * @param answer answer
     * @return boolean if answer is correct
     */
    public static boolean check(int id, String answer) {
        String url = "https://projecteuler.info/problem=" + id;
        String formData = "answer_" + id + "=" + URLEncoder.encode(answer, StandardCharsets.UTF_8) + "&captcha=";
        try {
            byte[] formDataBytes = formData.getBytes(StandardCharsets.UTF_8);

            // get a cookie
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            String cookie = conn.getHeaderFields().get("set-cookie").get(0).split(";")[0];

            // send answer
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", Integer.toString(formDataBytes.length));
            conn.setRequestProperty("Cookie", cookie);
            conn.getOutputStream().write(formDataBytes);

            // check response
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            for (String line = ""; line != null; line = br.readLine()) {
                if (line.contains("Correct")) {
                    return true;
                }
                else if (line.contains("Wrong")) {
                    return false;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("No response found.");
    }
}
