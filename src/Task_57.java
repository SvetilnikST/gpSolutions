import java.io.*;
import java.util.Scanner;

public class Task_57 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("INPUT.txt"));
        int n = sc.nextInt();
        int c = sc.nextInt();
        long p = sc.nextLong();

        int[] x = new int[n + 1];
        int[] y = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        PrintWriter pw = new PrintWriter(new File("OUTPUT.txt"));
        for (int i = 0; i < n; i++) {
            double count = 0;
            for (int j = 0; j <= n; j++) {
                count += Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
            }
            if (count * c <= p) {
                pw.print("YES");
                pw.close();
            }
        }
        pw.print("NO");
        pw.close();
    }
}
