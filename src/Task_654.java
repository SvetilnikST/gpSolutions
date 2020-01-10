import java.io.*;

public class Task_654 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        int n = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split("\\s");
        int[] arr = new int[s.length];
        int last, sum = 0, max = arr[0];
        int len = s.length - 1;
        if (n >=1 && n <= 200000 && len >= 1 && len < n) {
            for (int i = 0; i < s.length; i++) {
                int k = Integer.parseInt(s[i]);
                if (k >= 1 && k <= Math.pow(10, 9)) {
                    arr[i] = k;
                }
            }
            last = arr[0];
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
            String string = Integer.toString(sum);
            PrintWriter out = new PrintWriter("OUTPUT.txt");
            out.print(string);
            out.close();
        }
    }
}
