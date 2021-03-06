import java.io.*;

public class Task_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s1 = br.readLine().split("\\s");
        int n = Integer.parseInt(s1[0]);

        if (n >= 2 && n <= 30000) {
            String[] s2 = br.readLine().split("\\s");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(s2[i]);
                if (k >= 1 && k <= 32000) {
                    a[i] = k;
                }
            }
            if (a.length == n) {
                int[] prefix = new int[n + 1];
                for (int i = 0; i < n + 1; i++) {
                    prefix[i] = 0;
                }
                int rez = find(n, a, prefix);
                PrintWriter out = new PrintWriter("OUTPUT.txt");
                String text = Integer.toString(rez);
                out.print(text);
                out.close();
            }
        }
    }

    public static int find(int n, int[] a, int[] prefix) {
        int rez;
        int len = 0;
        for (int i = 1; i < n; i++) {
            while (true) {
                if (a[len] == a[i]) {
                    len++;
                    break;
                }
                if (len == 0) {
                    break;
                }
                len = prefix[len];
            }
            prefix[i + 1] = len;
        }
        while (true) {
            int period = n - len;
            if ((n - 1) % period == 0) {
                rez = period;
                break;
            }
            assert (len > 1);
            len = prefix[len];
        }
        return rez;
    }
}
