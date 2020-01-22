import java.io.*;

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
                x[i] = Integer.parseInt(s[0]);
                y[i] = Integer.parseInt(s[1]);
            }
            String[] s = br.readLine().split("\\s");
            x[n] = Integer.parseInt(s[0]);
            y[n] = Integer.parseInt(s[1]);

            int minIdn = 0;
            double count = dist(x[minIdn], x[n], y[minIdn], y[n]);
            for (int i = 0; i < n - 2; i++) {
                double tmp = dist(x[i], x[n], y[i], y[n]);
                if (tmp < count) {
                    minIdn = i;
                    count = tmp;
                }
            }
            for (int i = 0; i < n - 2; i++) {
                count += dist(x[minIdn], x[i + 1], y[minIdn], y[i + 1]);
            }
            String text;
            if (count * c <= p) {
                text = "YES";
            } else text = "NO";
            PrintWriter out = new PrintWriter("OUTPUT.txt");
            out.print(text);
            out.close();
        }
    }

    public static double sqr(double x) {
        return x * x;
    }

    public static double dist(double x1, double x2, double y1, double y2) {
        return (Math.sqrt(sqr(x2 - x1) + sqr(y2 - y1)));
    }
}
