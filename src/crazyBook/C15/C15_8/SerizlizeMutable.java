package crazyBook.C15.C15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
* 当使用java序列化机制序列化可变对象时一定要注意,只有第一次调用
* writeObject()方法来输出对象时才会将对象转换成字节序咧,并写入
* 到ObjectOutputStream;
* 在后面程序中即时该对象的实例变量发生了改变,再次调用writeObject()
* 方法输出该对象时,改变后的实例变量也不会被输出
* */

public class SerizlizeMutable {
    public static void main(String[] args) {
        try (
                ObjectOutputStream oos =
                        new ObjectOutputStream(
                                new FileOutputStream("mutable.txt")
                        );
                ObjectInputStream ois =
                        new ObjectInputStream(
                                new FileInputStream("mutable.txt")
                        )
        ) {
            Person per = new Person("黄永琦", 500);
            //系统将per对象转换成字节序列并输出
            oos.writeObject(per);
            //改变per对象的name实例变量
            per.setName("猪八戒");
            //系统只是输出序列化序号,所以改变后的name不会被序列化
            oos.writeObject(per);
            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            //下面输出true,即反序列化后p1等于p2
            System.out.println(p1 == p2);
            //下面依然看到输出"黄永琦",即改变后的实例变量没有被序列化
            System.out.println(p2.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
