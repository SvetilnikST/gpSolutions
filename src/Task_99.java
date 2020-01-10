import java.io.*;

public class Task_99 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = reader.readLine().split("\\s");

        int h = Integer.parseInt(s[0]) + 2;
        int m = Integer.parseInt(s[1]) + 2;
        int n = Integer.parseInt(s[2]) + 2;

        int arr[][][] = new int[h][m][n];

        int[] start = new int[3];
        int[] finish = new int[3];
        int[] current = new int[3];


        String str = "";

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {

                if (j != 0 && j != m - 1 && i != 0 && i != h - 1) {
                    str = reader.readLine();
                }

                for (int k = 0; k < n; k++) {

                    if (j == 0 || j == m - 1 || k == 0 || k == n - 1) {
                        arr[i][j][k] = -1;
                    } else {
                        if (str.charAt(k - 1) == 46) {
                            arr[i][j][k] = 0;
                        }
                        if (str.charAt(k - 1) == 111) {
                            arr[i][j][k] = -1;
                        }
                        if (str.charAt(k - 1) == 49) {
                            arr[i][j][k] = 0;
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;

                        }
                        if (str.charAt(k - 1) == 50) {
                            arr[i][j][k] = 0;
                            finish[0] = i;
                            finish[1] = j;
                            finish[2] = k;
                        }
                    }
                }
            }
            reader.readLine();
        }

        int a = 0;
        boolean prohodim = false;

//        for (int i = 0; i < h; i++) {
//            for (int j = 1; j < m-1; j++) {
//                for (int k = 0; k < n; k++) {
//
//
//                }
//            }
//        }

//        if (arr[current[0] - 1][current[1]][current[2]] == 0) {
//
//        }
//        step(current);


//        while (start[0] == finish[0] && start[1] == finish[1] && start[2] == finish[2]) {
//
//
//            for (int i = 0; i < h; i++) {
//                if (markedNode[i] == markNumber) {                                          // начинаем со стартового узла
//                    for (int j = 0; j < elementManager.GetNode(i).near.size(); j++) {       // просматриваем все соседние узлы
//                        if (markedNode[elementManager.GetNode(i).near.get(j).number] == 0    // если он еще не получил "отметку"
//                                && elementManager.GetNode(i).near.get(j).isEnable) {              // если доступен
//                            markedNode[elementManager.GetNode(i).near.get(j).number] = (markNumber + 1);
//                        }
//                    }
//                }
//            }
//            markNumber++;
//
//        }
    }

}
