package step_2;

import java.io.*;

public class Task_46 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("INPUT.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] k = new int[]{2, 7, 1, 8, 2, 8, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5, 2, 3, 5, 3, 6, 0, 2, 8, 7, 5};
        String text = "";
        if (n > 0 && n < 25) {
            text += "2.";
            for (int i = 1; i < n; i++) {
                text += Integer.toString(k[i]);
            }
            if (k[n + 1] > 4) {
                text += Integer.toString(k[n] + 1);
            } else {
                text += Integer.toString(k[n]);
            }
        } else if (n == 0) {
            text = "3";
        } else if (n == 25) {
            text = "2.7182818284590452353602875";
        }
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.print(text);
        out.close();
    }
}