package crazyBook.C15.C15_7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
    public static void main(String[] args) {
        try (
                //以读,写方式打开一个RandomAccessFile对象
                RandomAccessFile randomAccessFile =
                        new RandomAccessFile("out.txt", "rw")
        ) {
            //将记录指针移动到out.txt方法的最后
            System.out.println(randomAccessFile.length());
            randomAccessFile.seek(randomAccessFile.length());
            //在该字符串后使用"\r\n"是为了换行
            randomAccessFile.write("追加的内容!\r\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
