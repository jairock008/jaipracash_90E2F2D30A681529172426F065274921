import java.io.*;
import java.util.Scanner;

public class SixthExercise {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a few words:");

        String source = scan.nextLine();
        int lines = 0, char1 = 0, c = 0, words = 0;
        boolean temp = true;

        String whitespace = " ";  // You may want to specify the whitespace characters.

        OutputStream fos = new FileOutputStream("mno.txt");
        byte[] b = source.getBytes();
        fos.write(b);
        fos.close();

        System.out.println("File Created");

        InputStream fis = new FileInputStream("mno.txt");

        while ((c = fis.read()) != -1) {
            char1++;

            if (c == '\n') {
                lines++;
            }

            int index = whitespace.indexOf(c);

            if (index == -1) {
                if (temp) {
                    words++;
                    temp = false;
                } else {
                    temp = true;
                }
            }
        }

        if (char1 != 0) {
            lines++;
        }

        System.out.println("Number of lines: " + lines);
        System.out.println("Number of Characters: " + char1);
        System.out.println("Number of words: " + words);
    }
}
