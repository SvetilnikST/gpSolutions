package step_2;

import java.io.*;

public class Task_317 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int z = Integer.parseInt(s[2]);
        int w = Integer.parseInt(s[3]);
        int p, c = 0;
        if (w >= 1 && w <= 1000) {
            if (x >= 1 && y >= 1 && z >= 1 && x <= 100 && y <= 100 && z <= 100) {
                for (int i = 0; i <= w / x; i++) {
                    for (int j = 0; j <= w / y; j++) {
                        p = w - (i * x) - (j * y);
                        if ((p >= 0) && (p % z == 0)) {
                            c++;
                        }
                    }
                }
            }
        }
        String string = Integer.toString(c);
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.print(string);
        out.close();
    }
}
