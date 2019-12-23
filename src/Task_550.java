import java.io.*;

public class Task_550 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"));
        int year = Integer.parseInt(reader.readLine());
        String date = null;
        if (year > 0 && year <= 9999) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                if (year < 10) date = "12/09/000";
                if (year < 100 && year >= 10) date = "12/09/00";
                if (year < 1000 && year >= 100) date = "12/09/0";
                if (year >= 1000) date = "12/09/";
            } else {
                if (year < 10) date = "13/09/000";
                if (year < 100 && year >= 10) date = "13/09/00";
                if (year < 1000 && year >= 100) date = "13/09/0";
                if (year >= 1000) date = "13/09/";
            }
            String text = date + year;
            PrintWriter out = new PrintWriter("OUTPUT.txt");
            out.print(text);
            out.close();
        }
    }
}
