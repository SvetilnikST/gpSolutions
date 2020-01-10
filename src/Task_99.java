import java.io.*;

public class Task_99 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");

        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int n = Integer.parseInt(s[2]);

        int arr[][][] = new int[h][m][n];
        int mark[][][] = new int[h][m][n];

        int iSt = 0, jSt = 0, kSt = 0;
        int iEnd = 0, jEnd = 0, kEnd = 0;

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
                        iSt = i;
                        jSt = j;
                        kSt = k;

                    }
                    if (str.charAt(k) == 50) {
                        arr[i][j][k] = 2;
                        iEnd = i;
                        jEnd = j;
                        kEnd = k;
                    }
                }
            }
            reader.readLine();
        }

        int i = iSt;
        int j = jSt;
        int k = kSt;

        int ie = iSt;
        int je = jSt;
        int ke = kSt;


        int a = 0;
    }
}
