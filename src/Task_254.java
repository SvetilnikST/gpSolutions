import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

        int[] rez = new int[countGraf];
        for (int i = 0; i < graf.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (graf[i] == arr[i][j]) {
                    rez[i] = arr[i][j + 1];
                } else if (graf[i] == arr[i + 1][j]) {
                    rez[i] = arr[i][j + 1];
                } else rez[i] = graf[i];
            }
        }

        int a = 0;
    }
}
