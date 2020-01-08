import java.io.*;

public class Task_53 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n][m];

        int red = 0;
        int green = 0;
        int blue = 0;
        int black = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 5 != 0 && arr[i][j] % 2 != 0 && arr[i][j] % 3 != 0) {
                    black += 1;
                }
                if (arr[i][j] % 5 != 0 && arr[i][j] % 2 == 0 && arr[i][j] % 3 != 0) {
                    red += 1;
                }
                if (arr[i][j] % 5 != 0 && arr[i][j] % 3 == 0) {
                    green += 1;
                }
                if (arr[i][j] % 5 == 0) {
                    blue += 1;
                }
            }
        }
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.println("RED : " + red);
        out.println("GREEN : " + green);
        out.println("BLUE : " + blue);
        out.println("BlACK : " + black);
        out.close();
    }
}
