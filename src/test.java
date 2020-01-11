import java.io.*;
import java.util.ArrayList;

public class test {

    int h;
    int m;
    int n;
    int arr[][][];
    int[] start;
    int[] finish;
    int[] current;
    ArrayList<int[]> arrayList;

    public static void main(String[] args) throws IOException {
        test app = new test();
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

        int a = 0;
        boolean prohodim = false;


        arrayList = new ArrayList<>();


        arrayList.add(start);
        int rez = 1;
        while (!arrayList.isEmpty() || rez == 1) {
            current = arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            rez = make_step(current);
            print_lab();
        }

        int b = 0;

    }

    private void print_lab() {
        for (int i = 1; i < h - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                for (int k = 1; k < n - 1; k++) {
                    System.out.printf("%3d", arr[i][j][k]);
                    if (k == n - 2) {
                        System.out.println("");
                    }
                }
            }
            System.out.println("");
        }
        System.out.println("----");
    }

    private int make_step(int[] current) {
        int rez = 0;
        int[] cur;
        //если старт равен финишу
        if (current[0] == finish[0] && current[1] == finish[1] && current[2] == finish[2]) {
            rez = 2;
            return rez;
        }
        //проверяем уровень выше
        if (arr[current[0] - 1][current[1]][current[2]] == -1) {
        } else {
            cur = new int[3];
            cur[0] = current[0] - 1;
            cur[1] = current[1];
            cur[2] = current[2];
            if (arr[cur[0]][cur[1]][cur[2]] == 0) {
                arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                arrayList.add(cur);
                rez = 1;
            } else {
                if (arr[cur[0]][cur[1]][cur[2]] <= arr[current[0]][current[1]][current[2]] + 1) {
                    //ничего не делаем
                    //оставлчем текущее значение
                } else {
                    //текущему значению присваеваем +1
                    arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                    arrayList.add(cur);
                    rez = 1;
                }
            }
        }
        //проверяем уровень ниже
        if (arr[current[0] + 1][current[1]][current[2]] != -1) {
            cur = new int[3];
            cur[0] = current[0] + 1;
            cur[1] = current[1];
            cur[2] = current[2];
            if (arr[cur[0]][cur[1]][cur[2]] == 0) {
                arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                arrayList.add(cur);
                rez = 1;
            } else {
                if (arr[cur[0]][cur[1]][cur[2]] <= arr[current[0]][current[1]][current[2]] + 1) {
                    //ничего не делаем
                    //оставлчем текущее значение
                } else {
                    //текущему значению присваеваем +1
                    arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                    arrayList.add(cur);
                    rez = 1;
                }
            }

        }
        //СВЕРХУ
        if (arr[current[0]][current[1] - 1][current[2]] != -1) {
            cur = new int[3];
            cur[0] = current[0];
            cur[1] = current[1] - 1;
            cur[2] = current[2];
            if (arr[cur[0]][cur[1]][cur[2]] == 0) {
                arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                arrayList.add(cur);
                rez = 1;
            } else {
                if (arr[cur[0]][cur[1]][cur[2]] <= arr[current[0]][current[1]][current[2]] + 1) {
                    //ничего не делаем
                    //оставлчем текущее значение
                } else {
                    //текущему значению присваеваем +1
                    arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                    arrayList.add(cur);
                    rez = 1;
                }
            }

        }
        //СНИЗУ
        if (arr[current[0]][current[1] + 1][current[2]] != -1) {
            cur = new int[3];
            cur[0] = current[0];
            cur[1] = current[1] + 1;
            cur[2] = current[2];
            if (arr[cur[0]][cur[1]][cur[2]] == 0) {
                arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                arrayList.add(cur);
                rez = 1;
            } else {
                if (arr[cur[0]][cur[1]][cur[2]] <= arr[current[0]][current[1]][current[2]] + 1) {
                    //ничего не делаем
                    //оставлчем текущее значение
                } else {
                    //текущему значению присваеваем +1
                    arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                    arrayList.add(cur);
                    rez = 1;
                }
            }

        }
        //СЛЕВА
        if (arr[current[0]][current[1]][current[2] - 1] != -1) {
            cur = new int[3];
            cur[0] = current[0];
            cur[1] = current[1];
            cur[2] = current[2] - 1;
            if (arr[cur[0]][cur[1]][cur[2]] == 0) {
                arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                arrayList.add(cur);
                rez = 1;
            } else {
                if (arr[cur[0]][cur[1]][cur[2]] <= arr[current[0]][current[1]][current[2]] + 1) {
                    //ничего не делаем
                    //оставлчем текущее значение
                } else {
                    //текущему значению присваеваем +1
                    arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                    arrayList.add(cur);
                    rez = 1;
                }
            }

        }
        //СПРАВА
        if (arr[current[0]][current[1]][current[2] + 1] != -1) {
            cur = new int[3];
            cur[0] = current[0];
            cur[1] = current[1];
            cur[2] = current[2] + 1;
            if (arr[cur[0]][cur[1]][cur[2]] == 0) {
                arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                arrayList.add(cur);
                rez = 1;
            } else {
                if (arr[cur[0]][cur[1]][cur[2]] <= arr[current[0]][current[1]][current[2]] + 1) {
                    //ничего не делаем
                    //оставлчем текущее значение
                } else {
                    //текущему значению присваеваем +1
                    arr[cur[0]][cur[1]][cur[2]] = arr[current[0]][current[1]][current[2]] + 1;
                    arrayList.add(cur);
                    rez = 1;
                }
            }
        }
        return rez;
    }
}