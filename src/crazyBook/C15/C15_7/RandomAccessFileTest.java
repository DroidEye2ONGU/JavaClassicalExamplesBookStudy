package crazyBook.C15.C15_7;



import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {

        try (
                RandomAccessFile randomAccessFile =
                        new RandomAccessFile(
                                "C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\C15_7\\RandomAccessFileTest.java",
                                "r"
                                )
        ) {
            //获取RandomAccessFile对象的文件指针的位置,初始位置是0
            System.out.println(
                    "RandomAccessfile的文件指针的初始位置:"
                            + randomAccessFile.getFilePointer()
            );
            randomAccessFile.seek(300);

            byte[] bbuf = new byte[1024];

            //用于保存实际读取的字节数
            int hasRead = 0;
            //使用循环来重复取水的过程
            while ((hasRead = randomAccessFile.read(bbuf)) > 0) {
                System.out.println(
                        new String(bbuf,0,hasRead)
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

