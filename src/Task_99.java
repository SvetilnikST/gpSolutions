import java.io.*;

public class Task_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");

        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int n = Integer.parseInt(s[2]);

        int arr[][][] = new int[h][m][n];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                String str = reader.readLine();

                for (int k = 0; k < n; k++) {
                    if (str.charAt(k) == 46) {
                        arr[i][j][k] = 0;
                    }
                    if (str.charAt(k) == 111) {
                        arr[i][j][k] = 3;
                    }
                    if (str.charAt(k) == 49) {
                        arr[i][j][k] = 1;
                    }
                    if (str.charAt(k) == 50) {
                        arr[i][j][k] = 2;
                    }
                }
            }
            reader.readLine();
        }

        int a = 0;
    }
}
