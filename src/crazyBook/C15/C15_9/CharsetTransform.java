package crazyBook.C15.C15_9;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class CharsetTransform {
    public static void main(String[] args) throws Exception{
        //创建简体中文对应的Charset
        //Charset cn = Charset.forName("UTF-8");

        /*Java7新增了一个StandardCharsets类,该类包含了
        ISO-8859-1 UTF-8 UTF-16等类变量,这些类变量
        代表了最常用的字符集对应的Charset对象*/
        Charset cn = StandardCharsets.UTF_8;

        //获取cn对象对应的编码器和解码器
        CharsetEncoder cnEncoder = cn.newEncoder();
        CharsetDecoder cnDecoder = cn.newDecoder();

        //创建一个CharBuffer对象
        CharBuffer cbuff = CharBuffer.allocate(8);
        cbuff.put('孙');
        cbuff.put('悟');
        cbuff.put('空');
        cbuff.flip();

        //将CharBuffer中的字符序列转换成字节序列
        //ByteBuffer bbuff = cnEncoder.encode(cbuff);
        ByteBuffer bbuff = StandardCharsets.UTF_8.encode(cbuff);


        //循环访问ByteBuffer中的每个字节
        for (int i = 0; i < bbuff.limit(); i++) {
            System.out.print(bbuff.get(i) + "");
        }

        //将ByteBuffer的数据解码成字符序列
        //System.out.println("\n" + cnDecoder.decode(bbuff));
        CharBuffer cbuff2 = StandardCharsets.UTF_8.decode(bbuff);
        System.out.println("\n" + cbuff2);
    }
}
