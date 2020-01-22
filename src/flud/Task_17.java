package flud;

import java.io.*;
import java.util.ArrayList;

public class Task_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s1 = br.readLine().split("\\s");
        int n = Integer.parseInt(s1[0]);

        if (n >= 2 && n <= 30000) {
            String[] s2 = br.readLine().split("\\s");
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(s2[i]);
                if (k >= 1 && k <= 32000) {
                    a.add(k);
                }
            }
            if (a.size() == n) {
                ArrayList<Integer> prefix = new ArrayList<>();
                for (int i = 0; i < n + 1; i++) {
                    prefix.add(i, 0);
                }
                int rez = find(n, a, prefix);
                PrintWriter out = new PrintWriter("OUTPUT.txt");
                String text = Integer.toString(rez);
                out.print(text);
                out.close();
            }
        }
    }

    public static int find(int n, ArrayList<Integer> a, ArrayList<Integer> prefix) {
        int rez;
        int len = 0;
        for (int i = 1; i < n; i++) {
            while (true) {
                if (a.get(len).equals(a.get(i))) {
                    len++;
                    break;
                }
                if (len == 0) {
                    break;
                }
                len = prefix.get(len);
            }
            prefix.set(i + 1, len);
        }
        while (true) {
            int period = n - len;
            if ((n - 1) % period == 0) {
                rez = period;
                break;
            }
            assert (len > 1);
            len = prefix.get(len);
        }
        return rez;
    }

}
