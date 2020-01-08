package step_1;

import java.io.*;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("INPUT.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        if (n > 0 && n != 0) {
            for (int i = 1; i <= n; i++) {
                sum += i;
            }

        } else {
            for (int i = 1; i >= n; i--) {
                sum += i;
            }
        }
        String text = Integer.toString(sum);
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.print(text);
        out.close();
    }
}
