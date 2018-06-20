package crazyBook.C15.C15_8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
*下面程序中创建了一个ObjectOutputStream输出流,这个ObjectOutputStream输出流
* 建立在一个文件输出流的基础之上
* 用writeObject()方法将一个Person对象写入输入流.
* */
public class WriteObject {
    public static void main(String[] args) {
        try (
                //创建一个ObjectOutputStream输出流
                ObjectOutputStream oos =
                        new ObjectOutputStream(
                                new FileOutputStream("object.txt")
                        )
        ) {
            Person person = new Person("孙悟空", 500);
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
