import java.io.*;

public class Task_254 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        int countGraf = Integer.parseInt(reader.readLine());
        int[] graf = new int[countGraf];
        String[] s = reader.readLine().split("\\s");
        for (int i = 0; i < s.length; i++) {
            graf[i] = Integer.parseInt(s[i]);
        }
        int countStat = Integer.parseInt(reader.readLine());
        int[][] arr = new int[countStat][countStat];
        for (int i = 0; i < countStat; i++) {
            String[] replace = reader.readLine().split("\\s");
            for (int j = 0; j < countStat; j++) {
                arr[i][j] = Integer.parseInt(replace[j]);
            }
        }
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < graf.length; i++) {
                if (graf[i] == arr[j][0]) {
                    out.print(arr[j][1]);
                } else if (graf[i] == arr[j + 1][0]) {
                    out.print(arr[j + 1][1]);
                } else {
                    out.print(graf[i]);
                }
                if (i != graf.length - 1) out.print(" ");
            }
        }
        out.close();
    }
}
