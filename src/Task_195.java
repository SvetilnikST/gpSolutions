import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task_195 {

    private static final int countParam = 3;
    private static final int border = 100;
    private static final int countSide = 2;

    private static int getCount(int N, int A, int B) {
        return getSquareForOnePlate(A, B) * N;
    }

    private static int getSquareForOnePlate(int A, int B) {
        return (A * B) * countSide;
    }

    private static int[] readFile() {
        BufferedReader reader = null;

        try {
            int count = 0;
            int[] rez = new int[countParam];
            reader = new BufferedReader(new FileReader("INPUT.txt"));
            String tmp = "";
            while ((tmp = reader.readLine()) != null) {
                String[] s = tmp.split("\\s");

                for (int i = 0; i < s.length; i++) {
                    if (!s[i].equals(" ") && Integer.parseInt(s[i]) <= border) {
                        rez[i] = Integer.parseInt(s[i]);
                        count++;
                    }
                }
                if (count == countParam) {
                    return rez;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new int[0];
    }

    private static void writeAnswer(int answer) throws IOException {
        FileWriter fileWriter = new FileWriter("OUTPUT.txt");
        fileWriter.write(String.valueOf(answer));
        fileWriter.flush();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {

        int[] k = readFile();

        if (k.length == countParam) {
            int N = k[0];
            int A = k[1];
            int B = k[2];
            writeAnswer(getCount(N, A, B));
        } else System.out.println("Введены не верные параметры");
    }
}
