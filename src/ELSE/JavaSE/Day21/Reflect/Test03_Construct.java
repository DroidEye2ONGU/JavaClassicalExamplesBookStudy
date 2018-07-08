package ELSE.JavaSE.Day21.Reflect;

import java.lang.reflect.Constructor;

import ELSE.JavaSE.Day21.Bean.Student;

/*
 * 测试字节码对象中 构造器实例化对象
 * */
public class Test03_Construct {
    public static void main(String[] args) throws Exception {
        //反射实例化Student对象
        Class<Student> studentClass = (Class<Student>) Class.forName("ELSE.JavaSE.Day21.Bean.Student");

        /*Student student1 = studentClass.newInstance();
       //必须通过有参构造器去实例化对象
        System.out.println(student1);*/

        //获取所有构造方法
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();

        //获取所有公有(public)的构造方法
        Constructor<?>[] constructors = studentClass.getConstructors();



        //通过字节码对象获取指定构造器对象
        Constructor<Student> cons = studentClass.getConstructor(String.class, int.class);
        //通过构造器对象 调用 实例化对象
        Student student = cons.newInstance("aa", 1);
        System.out.println(student);
    }
}
