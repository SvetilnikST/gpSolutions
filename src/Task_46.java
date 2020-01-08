import java.io.*;

public class Task_46 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("INPUT.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] k = new int[]{2, 7, 1, 8, 2, 8, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5, 2, 3, 5, 3, 6, 0, 2, 8, 7, 5};
        String text = "";
        if (n == 0) {
            text = "3";
        } else if (n > 0 && n < k.length) {
            for (int i = 0; i <= n; i++) {

                if (i == 1) {
                    text += ".";
                }
                if (i == k.length - 1 || i != n) {
                    text += Integer.toString(k[i]);
                } else {
                    if (k[i] >= 5) {
                        if (k[i + 1] >= 5) {
                            text += Integer.toString(k[i] + 1);
                        } else text += Integer.toString(k[i]);
                    } else text += Integer.toString(k[i]);
                }
            }
        }
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.print(text);
        out.close();
    }
}
