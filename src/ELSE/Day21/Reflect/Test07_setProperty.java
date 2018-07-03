package ELSE.Day21.Reflect;


import java.lang.reflect.Method;

import javax.jws.Oneway;

import ELSE.Day21.Bean.Student;

/*
*  public void setProperty(Object obj, String propertyName, Object value){}
*  ，此方法可将obj对象中名为propertyName的属性的值设置为value。
* */
public class Test07_setProperty {

    public static void setProperty(Object o,
                                   String propertyName, Object value) throws Exception{
        Class<?> aClass = o.getClass();
        String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        Method declaredMethod = aClass.getDeclaredMethod(methodName, String.class);

        declaredMethod.invoke(o, value);
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        setProperty(student, "name", "老王");
        System.out.println(student);
    }
}
