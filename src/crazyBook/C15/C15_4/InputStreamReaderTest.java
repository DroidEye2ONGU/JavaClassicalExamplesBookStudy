package crazyBook.C15.C15_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 下面程序中的代码负责将System.in包装成BufferedReader,BufferedReader
* 流具有缓冲功能,它可以以换行符为标志一次读取一行文本,如果它没有读到
* 换行符,则程序阻塞,等到读到换行符为止.
*
*由于BufferedReader具有一个readLine()方法,可以非常方便的一次
* 读入一行内容.所以经常把读取文本内容的输入流包装成BufferedReader,
* 用来方便地读取输入流的文本内容
*
* */

public class InputStreamReaderTest {
    public static void main(String[] args) {
        try (
                //将System.in对象转换成Reader对象
                InputStreamReader inputStreamReader =
                        new InputStreamReader(System.in);
                BufferedReader bufferedReader =
                        new BufferedReader(inputStreamReader)
        ) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //如果读取的字符串为exit,则程序退出
                if (line.equals("exit")) {
                    System.exit(1);
                }
                //打印读取的内容
                System.out.println("输入内容为:" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
