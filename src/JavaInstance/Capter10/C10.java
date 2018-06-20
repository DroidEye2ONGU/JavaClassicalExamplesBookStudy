package JavaInstance.Capter10;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C10 {

    //使用System.in变量的read()方法从控制台获得一个字节
    public static void systemInTest() throws IOException {
        int a = System.in.read();
        System.out.println(a);
        System.out.println((char)a);
    }

    //字符转换器
    public static void bufferedReaderTest() throws IOException {
        /*
        * BufferedReader类是Reader类的特殊子类，它能读取整行字符
        * 两类输入类：
        * Streams: System.in
        * Readers:
        *
        * 由于BufferedReader类是一个Readers类，这需要将Stream类（如System.in）作为参数
        * 传递给InputStreamReader构造函数以获得一个Reader类，然后，将这个Reader对象传递
        * 给BufferedReader构造函数
        * 常见写法如下↓将字节流转换成字符流
        * BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        * 然后，可以使用BufferedReader的readLine()方法从标准输入设备读取整行文本。
        * 该方法没有形参，返回一个字符串。该字符串包含文本的下一行字符。如果没有其他行，
        * 就返回空值。
        * */
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;

        while ((inputLine = is.readLine()) != null) {
            System.out.println(inputLine);
        }
        is.close();
    }

    //利用BufferedReader从标准输入读取一个整数
    public static void bufferedReaderToReadInteger() {
        String line = null;
        int val = 0;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            line = is.readLine();
            val = Integer.parseInt(line);
            System.out.println("I read this number: " + val);
        } catch (NumberFormatException e) {
            System.err.println("Not a valid number:" + line);
        } catch (IOException e) {
            System.err.println("Unexpected IO ERROR:" + e);
        }
    }

    //从Console中读取密码
    //IDE如IJ和Eclipse中都不会存在console
    public static void readPassFromConsole() {
        Console console;
        if ((console = System.console()) != null) {
            char[] password = null;
            try {
                password = console.readPassword("Password:");
                System.out.println("Your password is:" + new String(password));
            } finally {
                if (password != null) {
                    Arrays.fill(password, ' ');
                }
            }
        } else {
            throw new RuntimeException("No console, can't get password");
        }
    }

    public static void main(String[] args) throws IOException {
        readPassFromConsole();
    }

}
