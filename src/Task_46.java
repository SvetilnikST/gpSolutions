import java.io.*;

public class Task_46 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("INPUT.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] k = new int[]{2, 7, 1, 8, 2, 8, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5, 2, 3, 5, 3, 6, 0, 2, 8, 7, 5};
        StringBuilder rez = new StringBuilder();
        if (n > 0 && n <= 25) {
            for (int i = 0; i <= n; i++) {
                if (i == 1) {
                    rez.append(".");
                }
                rez.append(k[i]);
            }
        } else rez.append("3");
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.println(rez);
        out.close();
    }
}
