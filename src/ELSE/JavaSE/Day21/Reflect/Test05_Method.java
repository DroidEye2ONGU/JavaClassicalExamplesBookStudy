package ELSE.JavaSE.Day21.Reflect;

import java.lang.reflect.Method;

import ELSE.JavaSE.Day21.Bean.Student;

/*
 * 测试Method对象 执行成员函数
 * */
public class Test05_Method {
    public static void main(String[] args) throws Exception {
       //demo1()

        //使用 字节码对象  获取getAge方法,然后调用,获取对象的age属性
        Student s1 = new Student("Lucy", 21);
        Class<Student> studentClass = Student.class;
                                        //   函数名     参数.class
        Method method = studentClass.getDeclaredMethod("getAge");

        //设置访问权限
        method.setAccessible(true);
        //将method对象运行起来
        int age = (int) method.invoke(s1);
        System.out.println("s1.age=" + age);

        //利用Method对象修改s1的名字为Lily
        Method setName = studentClass.getDeclaredMethod("setName", String.class);
        setName.setAccessible(true);
        setName.invoke(s1, "Lily");
        System.out.println("s1.name:"+s1.getName());
    }

    private static void demo1() {
        Class<Student> studentClass = Student.class;

        //获取所有方法(Method)对象[包括从父类继承的]
        Method[] methods = studentClass.getMethods();
        System.out.println(methods.length);
        for (Method m :
                methods) {
            System.out.println(m.getName());
        }

        //获取 [本类]中 [所有的(包括私有)] 方法对象
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        System.out.println(declaredMethods.length);
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i].getName());
        }
    }
}
