import java.io.*;
import java.io.IOException;

public class Task_2 {

    private static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    private static int readFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("INPUT.txt"));
            String tmp = "";
            while ((tmp = reader.readLine()) != null) {
                String[] s = tmp.split("\\s");
                for (String res : s) return Integer.parseInt(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {

        int k = readFile();
        if (k > 0 && k <= 10000) {
            String text = Integer.toString(getSum(k));
            PrintWriter out = new PrintWriter("OUTPUT.txt");
            out.print(text);
            out.close();
        }

    }
}
