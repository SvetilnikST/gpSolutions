import java.io.*;

public class Task_654 {
    public static void main(String[] args) throws IOException {
        int n;
        long sum = 0;
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        n = Integer.parseInt(reader.readLine());
        if (n > 0 && n <= 200000) {
            String[] s = reader.readLine().split("\\s");
            if (s.length > 0 && s.length <= n) {
                int[] arr = new int[s.length];
                int max = arr[0];
                for (int i = 0; i < s.length; i++) {
                    int k = Integer.parseInt(s[i]);
                    if (k > 0 && k <= Math.pow(10, 9)) {
                        arr[i] = k;
                    }
                }
                int last = arr[0];
                for (int i = 1; i < n; i++) {
                    int cur = arr[i];
                    if (cur > max) {
                        max = cur;
                    }
                    if (cur > last) {
                        sum += cur - last;
                    }
                    last = cur;
                }
                sum += max - last;

                String string = Long.toString(sum);
                PrintWriter out = new PrintWriter("OUTPUT.txt");
                out.print(string);
                out.close();
            }
        }
    }
}