import java.io.*;

public class Task_317 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int z = Integer.parseInt(s[2]);
        int w = Integer.parseInt(s[3]);
        int count = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    if ((x * i) + (y * j) + (z * k) == w) {
                        count++;
                    }
                }
            }
        }
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.println(count);
        out.close();
    }
}
