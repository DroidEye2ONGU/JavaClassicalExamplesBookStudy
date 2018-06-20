package ELSE.Day12.HomeWork;

public class Student implements Comparable<Student> {
    private int id;
    private int grade;

    public Student() {
    }

    public Student(int id, int grade) {
        this.id = id;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return this.grade - o.grade;
    }
}
