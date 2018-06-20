package crazyBook.C15.C15_8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
*  java.io.InvalidClassException:
*  DemoPerson; local class incompatible:
*  stream classdesc serialVersionUID = -2071565876962058344,
*  local class serialVersionUID = -8345153069362641443

这是因为对象类实现Serializable就会有一个id值,
当改变对象中的数据时,这个id值会发生改变,但是文
本文件中的写入和读取的id还是以前的id值,造成id
值不匹配,就会报错,解决办法:对象类中会报一个黄
色的警告,点击这个警告按照编译器实现就行.
https://blog.csdn.net/jingru2017/article/details/78322356
* */


public class ReadObject {
    public static void main(String[] args) {
        try (
                //创建一个ObjectInputStream输入流
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("object.txt")
                )
        ) {
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
