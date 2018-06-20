package crazyBook.C15.C15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableTest {
    public static void main(String[] args) {

        try (
                ObjectOutputStream oos =
                        new ObjectOutputStream(
                                new FileOutputStream("Externalizable.txt")
                        );
                ObjectInputStream ois =
                        new ObjectInputStream(
                                new FileInputStream("Externalizable.txt")
                        )
        ) {
            PersonWithExternalizable per = new PersonWithExternalizable("黄永琦", 500);
            oos.writeObject(per);
            PersonWithExternalizable p = (PersonWithExternalizable) ois.readObject();

            System.out.println(p);
            System.out.println(p == per);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
