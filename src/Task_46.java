import java.io.*;

public class Task_46 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("INPUT.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
//        int[] k = new int[]{2, 7, 1, 8, 2, 8, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5, 2, 3, 5, 3, 6, 0, 2, 8, 7, 5};
        int[] k = new int[]{2, 7, 1, 8, 2, 9, 6};

        String text = "";

        if (n == 0) {
            text = "3";
        } else if (n > 0 && n < 26) {
            for (int i = 0; i < n; i++) {

                if (i == 1) {
                    text += ".";
                }

                if (i == n - 1) {
                    if (k[i + 1] > 4) {
                        if (k[i + 1] == 9) {
                            if (k[i + 2] > 4) {
                                text += Integer.toString(k[i] + 1);
                                text += Integer.toString(0);
                            } else {
                                text += Integer.toString(k[i]);
                                text += Integer.toString(k[i + 1]);
                            }
                        } else {
                            text += Integer.toString(k[i]);
                            text += Integer.toString(k[i + 1] + 1);
                        }
                    } else {
                        text += Integer.toString(k[i]);
                        text += Integer.toString(k[i + 1]);
                    }
                } else text += Integer.toString(k[i]);

            }
        }

        PrintWriter out = new PrintWriter("OUTPUT.txt");
        out.print(text);
        out.close();
        System.out.println(System.currentTimeMillis() - startTime);
    }
}