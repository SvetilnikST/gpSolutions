import java.io.*;
public class Task_53 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = br.readLine().split("\\s");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n][m];

        int r = 0;
        int g = 0;
        int bl = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (i + 1) * (j + 1);
                if (arr[i][j] % 5 != 0 && arr[i][j] % 2 != 0 && arr[i][j] % 3 != 0) {
                    b++;
                }
                if (arr[i][j] % 5 != 0 && arr[i][j] % 2 == 0 && arr[i][j] % 3 != 0) {
                    r++;
                }
                if (arr[i][j] % 5 != 0 && arr[i][j] % 3 == 0) {
                    g++;
                }
                if (arr[i][j] % 5 == 0) {
                    bl++;
                }
            }
        }
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        String text = "RED : " + r + "\n" + "GREEN : " + g + "\n" + "BLUE : " + bl + "\n" + "BlACK : " + b;
        out.print(text);
        out.close();
    }
}
