package crazyBook.C15.C15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*下面程序用writeObject()写入一个Person对象,但下一行使用readObject()方法
 *返回的实际上是一个ArrayList对象,这是因为Person类的writeReplace()方法返
 * 回了一个ArrayList对象,所以序列化机制在序列化Person对象时,实际上是转为序
 * 列化ArrayList对象
 * */
public class ReplaceTest {
    public static void main(String[] args) {
        try (
                //创建一个ObjectOutputStream输出流
                ObjectOutputStream oos =
                        new ObjectOutputStream(
                                new FileOutputStream("replace.txt")
                        );
                ObjectInputStream ois =
                        new ObjectInputStream(
                                new FileInputStream("replace.txt")
                        )

        ) {
            Person per = new Person("黄永琦", 500);
            //系统将per对象转换成字节序列并输出
            oos.writeObject(per);
            //反序列化读取到的是ArrayList
            ArrayList list = (ArrayList) ois.readObject();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
