package ELSE.Day16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetStudentFromTxt {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("a.txt")
                        )
                )
        ) {
            ArrayList<Student> students = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                students.add(new Student(t[0], t[1], Integer.parseInt(t[2]), t[3]));
            }

            students.forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
