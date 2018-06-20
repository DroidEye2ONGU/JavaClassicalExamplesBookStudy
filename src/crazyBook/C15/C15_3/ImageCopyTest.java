package crazyBook.C15.C15_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopyTest {

    public static void main(String[] args) {
        try (
                FileInputStream fileInputStream =
                        new FileInputStream("1.jpg");
                FileOutputStream fileOutputStream =
                        new FileOutputStream("2.jpg")
        ) {
            byte[] a = new byte[1024];
            int hasRead = 0;
            while ((
                    hasRead = fileInputStream.read(a)) > 0) {
                fileOutputStream.write(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
