package crazyBook.C15.C15_8;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadTeacher {
    public static void main(String[] args) {
        try (
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(
                                new FileInputStream("TeacherObject.txt")
                        )
        ) {
            //按照序列化写入顺序反序列化读入
            Teacher t1 = (Teacher) objectInputStream.readObject();
            Teacher t2 = (Teacher) objectInputStream.readObject();
            Person per = (Person) objectInputStream.readObject();
            Teacher t3 = (Teacher) objectInputStream.readObject();

            //输出true
            System.out.println("t1的student引用和per是否相同:" +
                    (t1.getStudent() == per));
            //输出true
            System.out.println("t2的student引用和per是否相同:" +
                    (t2.getStudent() == per));
            //输出true
            System.out.println("t2和t3是否是同一个对象:" +
                    (t2 == t3));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
