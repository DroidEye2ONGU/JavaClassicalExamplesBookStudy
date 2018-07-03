package ELSE.Day21.Reflect;

import java.lang.reflect.Field;

import ELSE.Day21.Bean.Student;

// Field:成员变量
public class Test04_Field {
    public static void main(String[] args) throws Exception{
        //获取字节码对象
        Class<?> aClass = Class.forName("ELSE.Day21.Bean.Student");
        Student s1 = (Student) aClass.
                getDeclaredConstructor(String.class, int.class).
                newInstance("Tom",25);

        //获取所有公共(public)的数据成员
        /*Field[] farr = aClass.getFields();
        System.out.println(farr.length);*/

        //获取所有数据成员
      /*  Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(declaredFields.length);
        System.out.println(declaredFields[0]);
        System.out.println(declaredFields[1]);*/


        //获取name Field对象
        Field f = aClass.getDeclaredField("name");
        System.out.println(false);

        //设置私有属性的权限
        f.setAccessible(true);
        String name = (String) f.get(s1);
        System.out.println("s1.name:" +name);
        //修改制定对象s1中的属性name的值
        // 操作的对象,属性值
        f.set(s1, "李四");
        System.out.println(s1);
    }
}
