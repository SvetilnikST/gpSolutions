import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task_99_my {

    int h;
    int m;
    int n;
    int arr[][][];
    int[] start;
    int[] finish;
    int[] current;
    ArrayList<int[]> arrayList;

    public static void main(String[] args) throws IOException {
        Task_99_my app = new Task_99_my();
        app.run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");

        h = Integer.parseInt(s[0]) + 2;
        m = Integer.parseInt(s[1]) + 2;
        n = Integer.parseInt(s[2]) + 2;

        arr = new int[h][m][n];

        start = new int[3];
        finish = new int[3];
        current = new int[3];

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
                        if (str.charAt(k - 1) == 49) {
                            arr[i][j][k] = 0;
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;

                        }
                        if (str.charAt(k - 1) == 50) {
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

        arrayList = new ArrayList<>(); //план посещения в виде списка
        arrayList.add(start);           //заносим начальную в план
        int count = 0;                  //считаем кол-во посещенных вершин

//        boolean done = false;


        while (!arrayList.isEmpty()) {
            current = arrayList.get(arrayList.size() - 1);//посещяем следующую по плану
            arrayList.remove(arrayList.size() - 1); //удаляем ее из плана

            //перебираем соседние с ней вершины на этом уровне
//            int curH = current[0];
            for (int u = 0; u < n; u++) {
            if (arr[current[0]][current[1]][current[2 - 1]] != -1) {

            }

            }


            //перебираем вершины над ней и под ней


            int a = 0;

            find(current);

//            make_step(current);

        }
    }

    private int find(int[] current) {


        return 0;
    }

    private int make_step(int[] current) {
        int rez = 0;
        int[] cur = current;
        if (arr[current[0] - 1][current[1]][current[2]] == -1) {
        } else {
            arr[current[0] - 1][current[1]][current[2]] += 1;
            cur[0] = current[0] - 1;
            cur[1] = current[1];
            cur[2] = current[2];
            arrayList.add(cur);
            make_step(cur);
        }
        if (arr[current[0] + 1][current[1]][current[2]] == -1) {
        } else {
            arr[current[0] - 1][current[1]][current[2]] += 1;
            rez = 1;
        }
        if (arr[current[0]][current[1] - 1][current[2]] == -1) {
        } else {
            arr[current[0]][current[1] - 1][current[2]] += 1;
            rez = 1;
        }
        if (arr[current[0]][current[1] + 1][current[2]] == -1) {
        } else {
            arr[current[0]][current[1] + 1][current[2]] += 1;
            rez = 1;
        }
        if (arr[current[0]][current[1]][current[2] - 1] == -1) {
        } else {
            arr[current[0]][current[1]][current[2] - 1] += 1;
            rez = 1;
        }
        if (arr[current[0]][current[1]][current[2] + 1] == -1) {
        } else {
            arr[current[0]][current[1]][current[2] - 1] += 1;
            rez = 1;
        }
        if (current[0] == finish[0] && current[1] == finish[1] && current[2] == finish[2]) {
            rez = 2;
        }
        return rez;
    }
}

