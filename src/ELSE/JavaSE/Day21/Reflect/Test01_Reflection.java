package ELSE.JavaSE.Day21.Reflect;

import ELSE.JavaSE.Day21.Bean.Student;

/*
 * 获取一个类的字节码对象
 * */
public class Test01_Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class.forName() 获取字节码对象
        //如果类已经加载,则直接获取字节码对象,如果没有则先加载类,然后获取字节码对象
        Class<?> aClass = Class.forName("ELSE.JavaSE.Day21.Bean.Student");//类的全包名[前提:字节码对象已经加载]
        System.out.println(aClass);

        //2. 类名.class 获取字节码对象
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);

        System.out.println(aClass==studentClass);

        //3.通过对象getClass()获取
        Student stu = new Student();
        Class<? extends Student> aClass1 = stu.getClass();
        System.out.println(aClass1==aClass);
    }
}
