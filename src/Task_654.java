import java.io.*;

public class Task_654 {
    public static void main(String[] args) throws IOException {
        long n, last, sum, max;
        String[] s;
        long[] arr;
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        n = Integer.parseInt(reader.readLine());
        if (n > 0 && n <= 200000) {
            s = reader.readLine().split("\\s");
            if (s.length > 0 && s.length <= n) {
                arr = new long[s.length];
                sum = 0;
                max = arr[0];
                for (int i = 0; i < s.length; i++) {
                    long k = Long.parseLong(s[i]);
                    if (k > 0 && k <= Math.pow(10, 9)) {
                        arr[i] = k;
                    }
                }
                last = arr[0];
                for (int i = 1; i < n; i++) {
                    long cur = arr[i];
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