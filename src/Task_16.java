import java.io.*;

public class Task_16 {
    private static int s = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s1 = br.readLine().split("\\s");
        int n = Integer.parseInt(s1[0]);
        if (n >= 1 && n <= 100) {
            find(n, 0);
            PrintWriter out = new PrintWriter("OUTPUT.txt");
            String text = Integer.toString(s);
            out.print(text);
            out.close();
        }
    }

    private static void find(int n, int k) {
        if (n < 0) return;
        if (n == 0) {
            s++;
            return;
        }
        for (int i = k + 1; i <= n; i++) {
            find(n - i, i);
        }
    }
}
