package flud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Task_57 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s1 = br.readLine().split("\\s");
        int n = Integer.parseInt(s1[0]);
        int c = Integer.parseInt(s1[1]);
        int p = Integer.parseInt(s1[2]);

        if (n > 0 && n <= Math.pow(10, 3) && c >= 0 && c <= Math.pow(10, 4) && p >= 0 && p <= Math.pow(10, 15)) {
            int[] x = new int[n + 1];
            int[] y = new int[n + 1];

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split("\\s");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                if (a >= -1000 && a <= 1000 && b >= -1000 && b <= 1000) {
                    x[i] = a;
                    y[i] = b;
                }
            }
            String[] s = br.readLine().split("\\s");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            if (a >= -1000 && a <= 1000 && b >= -1000 && b <= 1000) {
                x[n] = a;
                y[n] = b;
            }
            if (x.length == n + 1) {


//                int minIdn = 0;
//                double count = dist(x[minIdn], x[n], y[minIdn], y[n]);
//                for (int i = 0; i < n - 2; i++) {
//                    double tmp = dist(x[i], x[n], y[i], y[n]);
//                    if (tmp < count) {
//                        minIdn = i;
//                        count = tmp;
//                    }
//                }
//                for (int i = 0; i < n - 2; i++) {
//                    count += dist(x[minIdn], x[i + 1], y[minIdn], y[i + 1]);
//                }
//                String text;
//                if (count * c <= p) {
//                    text = "YES";
//                } else text = "NO";
                PrintWriter out = new PrintWriter("OUTPUT.txt");
//                out.print(text);
//                out.close();
                for (int i = 0; i < n; i++) {
                    double l = 0;
                    for (int j = 0; j <= n; j++) {
                        l += Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
                    }
                    if (l * c <= p) {
                        out.print("YES");
                        out.close();

                    }
                }
                out.print("NO");
                out.close();


            }
        }
    }

    public static double sqr(double x) {
        return x * x;
    }

    public static double dist(double x1, double x2, double y1, double y2) {
        return (Math.sqrt(sqr(x2 - x1) + sqr(y2 - y1)));
    }
}
