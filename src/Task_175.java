import java.io.*;

public class Task_175 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = br.readLine().split(":");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int tmp;

        if (h >= 0 && h <= 23 && m >= 0 && m <= 59) {
            if (h < 10) {
                tmp = 20;
            } else if (h < 17) {
                tmp = 24;
            } else if (h < 20) {
                tmp = 24 + 5;
            } else tmp = 24 + 10;

            int sum = tmp * 60 - (h * 60 + m);
            PrintWriter out = new PrintWriter("OUTPUT.txt");
            String text = Integer.toString(sum);
            out.print(text);
            out.close();
        }
    }
}
