package crazyBook.C15.C15_9;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
    public static void main(String[] args) {
        File f = new File("a.txt");
        try (
                //创建一个RandomAccessFile对象
                RandomAccessFile raf = new RandomAccessFile(f, "rw");
                //获取 RandomAccessFile对应的Channel
                FileChannel randomChannel = raf.getChannel()
        ) {
            //将Channel中的所有数据映射成ByteBuffer
            MappedByteBuffer byteBuffer = randomChannel.map(
                    FileChannel.MapMode.READ_ONLY, 0, f.length());
            //将Channel的记录指针移到最后
            //将Channel的记录指针移动到该Channel的最后,从而可以让程序将指定
            //byteBuffer追加到该Channel的后面.每次运行该程序,都会把a.txt的
            //文件内容复制一份,并将全部内容追加到该文件的后面
            randomChannel.position(f.length());
            //将buffer中的所有数据输出
            randomChannel.write(byteBuffer);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
