package ELSE.JavaSE.Day5.exercise4;

public class Classroom {
    public Teacher teacher;                        //保存教师
    public Student[] students = new Student[40];//保存学生
    public int index = 0;                        //保存学生数量

    public Teacher getTeacher() {
        //返回教室中的教师
        return teacher;
    }

    public Student[] getStudents() {
        //返回所有的学生
        return this.students;
    }

    public void setTeacher(Teacher tea) {
        //更换教师
        this.teacher = tea;
    }

    public void addStudent(Student stu) {
        //增加学生
        students[index] = stu;
        index++;
    }

    public boolean removeStudent(int idx) {
        //删除学生
        if (students[idx] == null) {
            return false;
        } else {
            students[idx] = null;
            index--;
            return true;
        }

    }

    public int getStudentNum() {
        //返回教室中学生的数量
        return index;
    }

    public void print() {
        //输出当前教室中的教师和学生的信息
        System.out.print("当前教师为：");
        getTeacher().print();

        System.out.println("目前共有" + getStudentNum() + "个学生,分别是");
        for (int i = 0; i < index; i++) {
            students[i].print();
        }
    }
}