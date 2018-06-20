package crazyBook.C15.C15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadResolveTest {
    public static void main(String[] args) {
        try (
                ObjectOutputStream oos =
                        new ObjectOutputStream(
                                new FileOutputStream("readResolve.txt")
                        );
                ObjectInputStream ois =
                        new ObjectInputStream(
                                new FileInputStream("readResolve.txt")
                        )
        ) {
            oos.writeObject(Orientation.HORIZONTAL);
            Orientation o = (Orientation) ois.readObject();
            System.out.println(Orientation.HORIZONTAL == o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


