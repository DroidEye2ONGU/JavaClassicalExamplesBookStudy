package crazyBook.C15.C15_2;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.function.Consumer;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream =
                new FileInputStream(
                        "C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\" +
                                "JavaClassicalExamplesBookStudy\\src\\JavaInstance." +
                                "Capter10\\C15_2\\FileInputStreamTest.java");
        byte[] bbff = new byte[1024];
        int hasRead = 0;

        while ((hasRead = fileInputStream.read(bbff)) > 0) {
            System.out.println(new String(
                    bbff,0,hasRead
            ));
        }

        fileInputStream.close();
    }
}
