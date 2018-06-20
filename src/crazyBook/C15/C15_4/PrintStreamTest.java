package crazyBook.C15.C15_4;

/*
* 处理流
* Java IO 中包含两种流,一种是直接与底层交互的节点流,一种是封装了
* 节点流的处理流.
* 处理流可以可以用来包装节点流,程序通过处理流来执行输入/输出功能,
* 让节点流与底层的I/O设备,文件交互.
* */
/*
* 识别处理流非常简单,只要流的构造器参数不是一个物理节点,而是已经
* 存在的流,那么这种流一定是处理流;而所有节点流都是直接以物理IO节
* 点作为构造器参数的.
* */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/*
* 上面程序中的先定义了一个节点输出流 FileOutputStream, 然后使用
* PrintStream 包装了该节点输出流,最后使用PrintStream输出字符串
* 和对象.......PrintStream的输出功能非常强大,前面程序中一直使用
* 的标准输出System.out的类型就是PrintStream
*
*
* */
public class PrintStreamTest {
    public static void main(String[] args) {
        try (
                FileOutputStream fos =
                        new FileOutputStream("test.txt");
                PrintStream ps = new PrintStream(fos)
        ) {
            //使用PrintStream执行输出
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    * 在使用处理流包装了底层节点流之后,关闭输入/输出资源时,只要
    * 关闭最上层的处理流即可.
    * 关闭最上层的处理流时,系统会自动关闭被该处理流包装的节点流.
    * */
}
