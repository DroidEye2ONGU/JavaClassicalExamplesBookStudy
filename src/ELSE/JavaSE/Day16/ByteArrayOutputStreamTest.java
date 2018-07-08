package ELSE.JavaSE.Day16;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("a.txt");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ) {

            int hasRead;
            byte[] bytes = new byte[6];

            while ((hasRead = fis.read(bytes)) > 0) {
                baos.write(bytes,0,hasRead);
            }

            System.out.println(baos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
