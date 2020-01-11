import java.io.*;
import java.util.ArrayList;

public class Task_99 {
    int h, m, n, count = 0;
    int arr[][][];
    int[] start;
    int[] finish;
    int[] current;
    ArrayList<int[]> arrayList;
    public static void main(String[] args) throws IOException {
        Task_99 app = new Task_99();
        app.run();
    }
    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");
        h = Integer.parseInt(s[0]) + 2;
        m = Integer.parseInt(s[1]) + 2;
        n = Integer.parseInt(s[2]) + 2;
        if (h - 2 >= 2 && m - 2 >= 2 && n - 2 >= 2 && h - 2 <= 50 && m - 2 <= 50 && n - 2 <= 50) {
            arr = new int[h][m][n];
            start = new int[3];
            finish = new int[3];
            current = new int[3];

            String str = "";
            int countOne = 0;
            int countTwo = 0;
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
                                countOne++;
                            }
                            if (str.charAt(k - 1) == 50 && i == h - 2) {
                                arr[i][j][k] = 0;
                                finish[0] = i;
                                finish[1] = j;
                                finish[2] = k;
                                countTwo++;
                            }
                        }
                    }
                }
                if (i != 0 && i != h - 1) {
                    reader.readLine();
                }
            }
            if (countOne == 1 && countTwo == 1) {
                arrayList = new ArrayList<>();
                arrayList.add(start);
                int rez = 1;
                while (!arrayList.isEmpty() || rez == 1) {
                    current = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size() - 1);
                    rez = make_step(current);
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
    private int make_step(int[] current) {
        int rez = 0;
        int[] cur;
        if (current[0] == finish[0] && current[1] == finish[1] && current[2] == finish[2]) {
            rez = 2;
            return rez;
        }
        if (arr[current[0] - 1][current[1]][current[2]] != -1) {
            cur = new int[3];
            cur[0] = current[0] - 1;
            cur[1] = current[1];
            cur[2] = current[2];
            rez = getRez(current, rez, cur);
        }
        if (arr[current[0] + 1][current[1]][current[2]] != -1) {
            cur = new int[3];
            cur[0] = current[0] + 1;
            cur[1] = current[1];
            cur[2] = current[2];
            rez = getRez(current, rez, cur);
        }
        if (arr[current[0]][current[1] - 1][current[2]] != -1) {
            cur = new int[3];
            cur[0] = current[0];
            cur[1] = current[1] - 1;
            cur[2] = current[2];
            rez = getRez(current, rez, cur);
        }
        if (arr[current[0]][current[1] + 1][current[2]] != -1) {
            cur = new int[3];
            cur[0] = current[0];
            cur[1] = current[1] + 1;
            cur[2] = current[2];
            rez = getRez(current, rez, cur);
        }
        if (arr[current[0]][current[1]][current[2] - 1] != -1) {
            cur = new int[3];
            cur[0] = current[0];
            cur[1] = current[1];
            cur[2] = current[2] - 1;
            rez = getRez(current, rez, cur);
        }
        if (arr[current[0]][current[1]][current[2] + 1] != -1) {
            cur = new int[3];
            cur[0] = current[0];
            cur[1] = current[1];
            cur[2] = current[2] + 1;
            rez = getRez(current, rez, cur);
        }
        return rez;
    }
    private int getRez(int[] current, int rez, int[] cur) {
        if (arr[cur[0]][cur[1]][cur[2]] == 0 || arr[cur[0]][cur[1]][cur[2]] > arr[current[0]][current[1]][current[2]] + 1) {
            arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
            arrayList.add(cur);
            rez = 1;
        }
        return rez;
    }
}