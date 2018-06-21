package crazyBook.C8.C8_4;

import java.util.Arrays;
import java.util.List;

/*
* Arrays工具类提供了一个asList(Object...a)方法,该方法可以把一个数组或指定个数的对象转换
* 成一个List集合,这个List集合既不是ArrayList实现类的实例,也不是Vector实现类的实例,而是
* Arrays的内部类的ArrayList的实例.
* Arrays.ArrayList是一个固定长度的List集合,程序只能遍历访问该集合里的元素,不可以增加,
* 删除该集合里的元素
* */
public class FixedSizeList {
    public static void main(String[] args) {
        List fixedList = Arrays.asList(
                "愣鬼先锋", "林中秋雨"
        );
        //获取fixedList的实现类,将输出Arrays$ArrayList
        System.out.println(fixedList.getClass());
        //使用方法引用遍历集合元素
        fixedList.forEach(System.out::println);

        //试图增加,删除元素都会引发UnsupportedOperationException异常
        /*fixedList.add(1);
        fixedList.add(2);*/
    }
}
