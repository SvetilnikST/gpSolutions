import java.io.*;
import java.util.ArrayList;

class Coord {
    int h;
    int m;
    int n;

    public Coord() {
        this.h = h;
        this.m = m;
        this.n = n;
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setN(int n) {
        this.n = n;
    }
}

public class Task_99_newTest {
    int h, m, n, count = 0;
    int arr[][][];
    ArrayList<Coord> arrayList;

    public static void main(String[] args) throws IOException {
        Task_99_newTest app = new Task_99_newTest();
        app.run();
    }

    private void run() throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");
        Coord start = new Coord();
        Coord finish = new Coord();
        int[] dh = {0, 0, 0, 0, 1};
        int[] dm = {0, 1, -1, 0, 0};
        int[] dn = {1, 0, 0, -1, 0};
        h = Integer.parseInt(s[0]) + 2;
        m = Integer.parseInt(s[1]) + 2;
        n = Integer.parseInt(s[2]) + 2;
        if (h - 2 >= 2 && m - 2 >= 2 && n - 2 >= 2 && h - 2 <= 50 && m - 2 <= 50 && n - 2 <= 50) {
            arr = new int[h][m][n];
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
                                start.setH(i);
                                start.setM(j);
                                start.setN(k);
                            }
                            if (str.charAt(k - 1) == 50 && i == h - 2) {
                                arr[i][j][k] = 0;
                                finish.setH(i);
                                finish.setM(j);
                                finish.setN(k);
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
                Coord cur = new Coord();
                cur.setH(arrayList.get(arrayList.size() - 1).getH());
                cur.setM(arrayList.get(arrayList.size() - 1).getM());
                cur.setN(arrayList.get(arrayList.size() - 1).getN());
                arrayList.remove(arrayList.size() - 1);

                for (int i = 0; i < 5; i++) {
                    Coord tmp = new Coord();
                    tmp.setH(cur.h + dh[i]);
                    tmp.setM(cur.m + dm[i]);
                    tmp.setN(cur.n + dn[i]);
                    if (tmp != start) {
                        if (arr[tmp.getH()][tmp.getM()][tmp.getN()] == 0 || arr[tmp.getH()][tmp.getM()][tmp.getN()] > arr[cur.getH()][cur.getM()][cur.getN()] + 1) {
                            arrayList.add(tmp);
                            arr[tmp.getH()][tmp.getM()][tmp.getN()] = arr[cur.getH()][cur.getM()][cur.getN()] + 1;
                        }
                    }
                }
            }
            count = arr[finish.getH()][finish.getM()][finish.getN()] * 5;
            if (count != 0) {
                String string = Integer.toString(count);
                PrintWriter out = new PrintWriter("OUTPUT.txt");
                out.print(string);
                out.close();
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}