package ELSE.Day5.exercise1;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("老王");
        student.setAge(18);
        student.setSex("男");

        System.out.println(student);

        student.increaseAge();
        System.out.println(student.getAge());
    }
}
