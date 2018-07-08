package ELSE.JavaSE.Day16;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ArrayListIO {
    public static void main(String[] args) {
        ArrayList<Student> data = new ArrayList<>();

        data.add(new Student("it001","张曼玉",35,"北京"));
        data.add(new Student("it002","王祖贤",33,"上海"));
        data.add(new Student("it003","林青霞",30,"西安"));

        try(
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("a.txt")
                        )
                )
                ) {

            for (int i = 0; i < data.size(); i++) {
                bw.write(data.get(i).toString2());
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
