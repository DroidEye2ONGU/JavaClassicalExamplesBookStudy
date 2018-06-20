package crazyBook.C15.C15_2;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    public static void main(String[] args) throws IOException {


        char[] cbuf = new char[32];
        int hasRead = 0;

        try (FileReader fileReader =
                     new FileReader(
                             "C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\FileReaderTest.java")) {
            while ((hasRead = fileReader.read(cbuf)) > 0) {
                System.out.println(new String(cbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
