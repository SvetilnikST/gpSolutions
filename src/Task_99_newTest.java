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
    int rez;

    public static void main(String[] args) throws IOException {
        Task_99_newTest app = new Task_99_newTest();
        app.run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");
        h = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        n = Integer.parseInt(s[2]);
        if (h >= 2 && m >= 2 && n >= 2 && h <= 50 && m <= 50 && n <= 50) {
            arr = new int[h][m][n];
            Coord start = new Coord();
            Coord finish = new Coord();
            int[] dh = {0, 0, 0, 0, 1};
            int[] dm = {0, 1, -1, 0, 0};
            int[] dn = {1, 0, 0, -1, 0};
            String str = "";
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < m; j++) {
                    str = reader.readLine();
                    for (int k = 0; k < n; k++) {
                        if (str.charAt(k) == 46) {
                            arr[i][j][k] = 0;
                        }
                        if (str.charAt(k) == 111) {
                            arr[i][j][k] = -1;
                        }
                        if (str.charAt(k) == 49) {
                            arr[i][j][k] = 0;
                            start.setH(i);
                            start.setM(j);
                            start.setN(k);

                        }
                        if (str.charAt(k) == 50) {
                            arr[i][j][k] = 0;
                            finish.setH(i);
                            finish.setM(j);
                            finish.setN(k);
                        }
                    }
                }
                reader.readLine();
            }
            arrayList = new ArrayList<>();
            arrayList.add(start);

            rez = 0;
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
                    if (ok(tmp)) {
                        if (arr[tmp.getH()][tmp.getM()][tmp.getN()] <= arr[cur.getH()][cur.getM()][cur.getN()] + 1) {
                            arrayList.add(tmp);
                            arr[tmp.getH()][tmp.getM()][tmp.getN()] = arr[cur.getH()][cur.getM()][cur.getN()] + 1;
                        }
                    }
                }
            }
            count = arr[finish.getH()][finish.getM()][finish.getH()] * 5;

            if (count != 0) {
                String string = Integer.toString(count);
                PrintWriter out = new PrintWriter("OUTPUT.txt");
                out.print(string);
                out.close();
            }
        }
    }

    boolean ok(Coord c) {
        if (c.getH() >= 0 && c.getH() < h)
            if (c.getM() >= 0 && c.getM() < m)
                if (c.getN() >= 0 && c.getN() < n)
                    if (arr[c.getH()][c.getM()][c.getN()] == 0)
                        return true;
        return false;
    }
}