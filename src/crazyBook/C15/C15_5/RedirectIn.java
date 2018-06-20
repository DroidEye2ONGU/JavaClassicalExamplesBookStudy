package crazyBook.C15.C15_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream(
                        "C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\RedirectIn.java"
                )
        ) {
            //将标准输入重定向到fis输入流
            System.setIn(fis);
            //使用System.in创建Scanner对象,获取标准输入
            Scanner sc = new Scanner(System.in);
            //增加下面一行只把回车作为分隔符
            sc.useDelimiter("\n");
            //判断是否还有下一个输入项
            while (sc.hasNext()) {
                //输出输入项
                System.out.println(sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
