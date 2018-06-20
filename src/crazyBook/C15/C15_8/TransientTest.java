package crazyBook.C15.C15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
    public static void main(String[] args) {
        try (
                ObjectOutputStream objectOutputStream =
                        new ObjectOutputStream(
                                new FileOutputStream("transient"));
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(
                                new FileInputStream("transient")
                        )
        ) {
            Person p = new Person("黄永琦", 50);
            objectOutputStream.writeObject(p);

            Person p2 = (Person)objectInputStream.readObject();
            System.out.println(p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
