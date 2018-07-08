package ELSE.JavaSE.Day5.exercise4;

public class ClassroomTest {
    public static void main(String[] args) {
        //创建Classroom对象
        Classroom classroom = new Classroom();

        //创建Teacher对象，并将Teacher分配到Classroom中
        Teacher teacher = new Teacher(001,"张老师",1000.0,001,25);
        classroom.setTeacher(teacher);

        //创建3个Student对象，并将Student分配到Classroom中
        Student student1 = new Student(001, "老李", 18);
        Student student2 = new Student(002, "老王", 19);
        Student student3 = new Student(003, "老张", 20);

        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        //调用Classroom中的其它方法，测试方法的业务逻辑是否准确
        classroom.print();
    }
}
