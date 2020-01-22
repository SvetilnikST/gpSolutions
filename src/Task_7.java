import java.io.*;

public class Task_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        String[] s = br.readLine().split("\\s");
        String s1 = s[0];
        String s2 = s[1];
        String s3 = s[2];

        find(s1, find(s2, s3));

        PrintWriter out = new PrintWriter("OUTPUT.txt");
        String text = find(s1, find(s2, s3));
        out.print(text);
        out.close();
    }

    private static String find(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return s1;
        }
        if (s1.length() < s2.length()) {
            return s2;
        }
        int tmp = s1.compareTo(s2);
        if (tmp >= 0) {
            return s1;
        } else return s2;
    }
}
