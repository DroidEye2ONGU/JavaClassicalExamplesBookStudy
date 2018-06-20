package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GbkToUTF {
    private static String filePath;
    private static String outPath;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.print("请输入要转换的GBK文件路径:");
        filePath = sc.next();

        System.out.println();
        System.out.print("请输入要输出的UTF-8文件路径:");
        outPath = sc.next();
        sc.close();

        File inF = new File(filePath);
        File outF = new File(outPath);
        try (
                FileChannel inChannel = new FileInputStream(inF).getChannel();
                FileChannel outChannel = new FileOutputStream(outF).getChannel()
        ) {


            MappedByteBuffer gbkByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inF.length());

            CharsetDecoder charsetDecoder = Charset.forName("gbk").newDecoder();

            CharBuffer gbkCharBuffer = charsetDecoder.decode(gbkByteBuffer);

            CharsetEncoder utfEncoder = StandardCharsets.UTF_8.newEncoder();

            ByteBuffer utfByteBuffer = utfEncoder.encode(gbkCharBuffer);


            outChannel.write(utfByteBuffer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
