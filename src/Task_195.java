import java.io.*;

public class Task_195 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");
        int N = Integer.parseInt(s[0]);
        int A = Integer.parseInt(s[1]);
        int B = Integer.parseInt(s[2]);
        int rez = A * B * 2 * N;
        String text = Integer.toString(rez);
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.print(text);
        out.close();
    }
}
