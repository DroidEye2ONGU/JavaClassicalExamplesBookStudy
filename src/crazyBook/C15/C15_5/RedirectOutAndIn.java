package crazyBook.C15.C15_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class RedirectOutAndIn {
    public static void main(String[] args) {
        try (
                PrintStream printStream =
                        new PrintStream(
                                new FileOutputStream("" +
                                        "RedirectOutAndIn.txt")
                        );
                FileInputStream fileInputStream =
                        new FileInputStream(
                                "C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\C15_5\\RedirectOutAndIn.java"
                        )
                ){

            System.setOut(printStream);
            System.setIn(fileInputStream);

            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");

            while (sc.hasNext()) {
                System.out.println(sc.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
