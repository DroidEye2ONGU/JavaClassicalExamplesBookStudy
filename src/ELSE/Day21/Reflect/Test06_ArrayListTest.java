package ELSE.Day21.Reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
/*
*  通过反射越过泛型检查,往ArrayList<Integer>中添加字符串
* */
public class Test06_ArrayListTest {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(233);
        Class<? extends ArrayList> listClass = list.getClass();

        Method addMethod = listClass.getDeclaredMethod("add", Object.class);

        addMethod.invoke(list, "刘格懒");

        for (Object a :
                list) {
            if (a.getClass() == String.class) {
                a = (String) a;
                System.out.println(a);
            } else {
                a = (Integer) a;
                System.out.println(a);
            }
        }
    }
}
