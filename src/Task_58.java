import java.io.*;

public class Task_58 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        int t = Integer.parseInt(reader.readLine());
        int n;
        int m;
        boolean x = true;
        PrintWriter out = new PrintWriter("OUTPUT.txt");
        for (int i = 0; i < t; i++) {
            String[] str = reader.readLine().split("\\s");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            if (n > 2) {
                //идем по строкам
                for (int j = 0; j < n - 1; j++) {
                    //сравниваем значения в текущей и следующей строке. обратить внимание чтобы не вылетить за пределы
                    String[] current = new String[0];

                    //если значение текущей переменной пустое, то начинаем считывать значение из файла, иначе присваиваем значение предыдушего
                    if (current!= null) {
                        current = reader.readLine().split("\\s");
                        String[] next = reader.readLine().split("\\s");
                        //проходимся по столбцам и сравнимаем значения в текущем и следующем столбце
                        for (int k = 0; k < m - 1; k++) {
                            if (Integer.parseInt(current[k] + current[k + 1] + next[k] + next[k + 1]) % 4 == 0) {
                                x = false;
                            }
                            //текущей строке присвоить значение следующей
                            current = next;
                        }
                    }else {
                        //текущая переменная пустая и ее нужно запонить

                    }
                }
            } else {
                //пишем в файл ДА
//                out.print("YES");
                x = true;
                reader.readLine();
            }
            if (x) {
                out.print("YES");
            } else out.print("NO");
        }
        out.close();
    }
}
