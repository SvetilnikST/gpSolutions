import java.io.*;

public class Task_58 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        int t = Integer.parseInt(reader.readLine());
        int n;
        int m;
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        for (int i = 0; i < t; i++) {
            String[] str = reader.readLine().split("\\s");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            boolean x = true;
            if (n > 1) {
                String[] current = null;
                String[] next;
                for (int j = 0; j < n - 1; j++) {
                    if (j == 0) {
                        current = reader.readLine().split("\\s");
                    }
                    next = reader.readLine().split("\\s");
                    for (int k = 0; k < m - 1; k++) {
                        if ((Integer.parseInt(current[k]) + Integer.parseInt(current[k + 1]) + Integer.parseInt(next[k]) + Integer.parseInt(next[k + 1])) % 4 == 0) {
                            x = false;
                        }
                    }
                    current = next;
                }
            } else {
                reader.readLine();
            }
            if (x) {
                out.println("YES");
            } else out.println("NO");
        }
        out.close();
    }
}
