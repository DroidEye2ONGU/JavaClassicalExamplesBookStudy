package crazyBook.C15.C15_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fileInputStream =
                        new FileInputStream(
                                "C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\C15_3\\FileOutputStreamTest.java");
                FileOutputStream fileOutputStream =
                        new FileOutputStream("newFile.txt")

        ) {

            byte[] bbuf = new byte[32];
            int hasRead = 0;
            while ((hasRead =
                    fileInputStream.read(bbuf)) > 0) {
                //每读取一次,即写入文件输出流,读了多少,就写多少
                fileOutputStream.write(bbuf, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
