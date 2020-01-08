package step_1;

import java.io.*;

public class Task_254 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        int n = Integer.parseInt(reader.readLine());
        int[] before = new int[n];
        int[] after = new int[n];
        int last;
        int next;
        String[] s = reader.readLine().split("\\s");
        for (int i = 0; i < s.length; i++) {
            before[i] = Integer.parseInt(s[i]);
            after[i] = before[i];
        }
        int m = Integer.parseInt(reader.readLine());
        for (int j = 0; j < m; j++) {
            String[] str = reader.readLine().split("\\s");
            last = Integer.parseInt(str[0]);
            next = Integer.parseInt(str[1]);
            for (int i = 0; i < before.length; i++) {
                if (before[i] == last) {
                    after[i] = next;
                }
            }
        }
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        for (int i = 0; i < after.length; i++) {
            if (i != after.length - 1) {
                out.print(after[i] + " ");
            } else
                out.print(after[i]);
        }
        out.close();
    }
}
