package step_2;

import java.io.*;
import java.util.ArrayList;

public class Task_99 {
    int h, m, n, count = 0;
    int arr[][][];
    ArrayList<int[]> arrayList;
    int[] start;
    int[] finish;
    int[] cur;

    public static void main(String[] args) throws IOException {
        Task_99 app = new Task_99();
        app.run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");
        int[] dh = {0, 0, 0, 0, 1};
        int[] dm = {0, 1, -1, 0, 0};
        int[] dn = {1, 0, 0, -1, 0};
        h = Integer.parseInt(s[0]) + 2;
        m = Integer.parseInt(s[1]) + 2;
        n = Integer.parseInt(s[2]) + 2;
        if (h - 2 >= 2 && m - 2 >= 2 && n - 2 >= 2 && h - 2 <= 50 && m - 2 <= 50 && n - 2 <= 50) {
            arr = new int[h][m][n];
            start = new int[3];
            finish = new int[3];
            cur = new int[3];
            String str = "";
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < m; j++) {
                    if (j != 0 && j != m - 1 && i != 0 && i != h - 1) {
                        str = reader.readLine();
                    }
                    for (int k = 0; k < n; k++) {
                        if (j == 0 || j == m - 1 || k == 0 || k == n - 1 || i == 0 || i == h - 1) {
                            arr[i][j][k] = -1;
                        } else {
                            if (str.charAt(k - 1) == 46) {
                                arr[i][j][k] = 0;
                            }
                            if (str.charAt(k - 1) == 111) {
                                arr[i][j][k] = -1;
                            }
                            if (str.charAt(k - 1) == 49 && i == 1) {
                                arr[i][j][k] = 0;
                                start[0] = i;
                                start[1] = j;
                                start[2] = k;
                            }
                            if (str.charAt(k - 1) == 50 && i == h - 2) {
                                arr[i][j][k] = 0;
                                finish[0] = i;
                                finish[1] = j;
                                finish[2] = k;
                            }
                        }
                    }
                }
                if (i != 0 && i != h - 1) {
                    reader.readLine();
                }
            }
            arrayList = new ArrayList<>();
            arrayList.add(start);

            while (!arrayList.isEmpty()) {
                cur = arrayList.get(arrayList.size() - 1);
                arrayList.remove(arrayList.size() - 1);

                for (int i = 0; i < 5; i++) {
                    int[] tmp = new int[3];
                    tmp[0] = cur[0] + dh[i];
                    tmp[1] = cur[1] + dm[i];
                    tmp[2] = cur[2] + dn[i];
                    if (tmp != start) {
                        if (arr[tmp[0]][tmp[1]][tmp[2]] == 0 || arr[tmp[0]][tmp[1]][tmp[2]] > arr[cur[0]][cur[1]][cur[2]] + 1) {
                            arrayList.add(tmp);
                            arr[tmp[0]][tmp[1]][tmp[2]] = arr[cur[0]][cur[1]][cur[2]] + 1;
                        }
                    }
                }
            }
            count = arr[finish[0]][finish[1]][finish[2]] * 5;
            if (count != 0) {
                String string = Integer.toString(count);
                PrintWriter out = new PrintWriter("OUTPUT.txt");
                out.print(string);
                out.close();
            }
        }
    }
}