package crazyBook.C15.C15_5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
* 下面程序中创建了一个PrintStream输出流,并将系统的标准输出重定向到
* 该PrintStream输出流.运行程序时将看不到任何输出,这意味着标准输出不
* 再输出到屏幕,而是输出到out.txt文件,运行结束后,打开系统当前路径下的
* out.txt文件,即可看到文件里的内容,正好与程序中的输出一致.
* */

//重定向标准输出流,将System.out的输出重定向到文件输出,而不是在屏幕上输出
public class RedirectOut {
    public static void main(String[] args) {
        try (
                 //一次性创建PrintStream输出流
                 PrintStream ps = new PrintStream(
                         new FileOutputStream("out.txt")
                 )
        ) {
            System.setOut(ps);
            //向标准输出输出一个字符串
            System.out.println("普通字符串");
            //向标准输出输出一个对象
            System.out.println(new RedirectOut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
