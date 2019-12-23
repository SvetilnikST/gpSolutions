import java.io.*;

public class Task_58 {
    public static void main(String[] args) throws IOException {
        boolean x = true;
        String text;

        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String[] s = reader.readLine().split("\\s");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            if (n > 1 && m > 1) {
                int[][] array = new int[n][m];

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        array[i][k] = Integer.parseInt(reader.readLine());
                    }
                }

                for (int c = 0; c < array.length - 1; c++) {
                    for (int j = 0; j < array[0].length - 1; j++) {
                        if ((array[c][j] + array[c][j + 1] + array[c + 1][j] + array[c + 1][j + 1]) % 4 == 0)
                            x = false;
                    }
                }
            } else {
                x = true;
            }

            if (x) {
                text = "YES";
            } else {
                text = "NO";
            }
            PrintWriter out = new PrintWriter("OUTPUT.txt");
            out.print(text);
            out.close();
        }
    }
}
