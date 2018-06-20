package crazyBook.C15.C15_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedTest {
    public static void main(String[] args) {
        try (
                //将System.in对象转换成Reader对象
                InputStreamReader reader =
                        new InputStreamReader(System.in);
                //将普通的Reader包装成BufferedReader
                BufferedReader br = new BufferedReader(reader)
        ) {
            String line = null;
            //采用循环方式来逐行的取值
            while ((line = br.readLine()) != null) {
                //如果读取的字符串为"exit"程序退出
                if (line.equals("exit")) {
                    System.exit(1);
                }
                //打印读取内容
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
