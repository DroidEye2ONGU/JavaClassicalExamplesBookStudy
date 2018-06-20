package crazyBook.C15.C15_9;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream(
                        "newFile.txt"
                        );
                FileChannel fileChannel = fis.getChannel()
        ) {
            //定义一个ByteBuffer对象,用于重复取水
            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            //将FileChannel中的数据放入ByteBuffer中
            while (fileChannel.read(byteBuffer) != -1) {
                /*
                * 每次读取数据后调用flip()方法将没有数据的区域"封印"起来,
                * 避免从Buffer中取出null值;
                * flip()将limit设为position,position设为0
                *
                **/
                /*
                * 数据取出后立即调用clear()方法将Buffer的position设0,
                * 为下一次读取数据做准备
                * clear()将position设为0,limit设为capacity
                * */


                //锁定Buffer空白区
                byteBuffer.flip();
                //创建Charset对象
                Charset charset = Charset.forName("utf-8");
                //创建解码器(CharsetDecoder)对象
                CharsetDecoder charsetDecoder = charset.newDecoder();
                //将ByteBuffer内容转码
                CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
                System.out.println(charBuffer);
                //将Buffer初始化,为下一次读取数据做准备
                byteBuffer.clear();
            }
        }
    }
}
