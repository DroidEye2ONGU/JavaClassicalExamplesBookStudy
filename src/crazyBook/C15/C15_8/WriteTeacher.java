package crazyBook.C15.C15_8;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteTeacher {
    public static void main(String[] args) {
        try (
                ObjectOutputStream objectOutputStream =
                        new ObjectOutputStream(
                                new FileOutputStream("TeacherObject.txt")
                        )
        ) {
            Person per = new Person("孙悟空", 500);
            Teacher t1 = new Teacher("唐僧", per);
            Teacher t2 = new Teacher("菩提祖师", per);

            objectOutputStream.writeObject(t1);
            objectOutputStream.writeObject(t2);
            objectOutputStream.writeObject(per);
            objectOutputStream.writeObject(t2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
