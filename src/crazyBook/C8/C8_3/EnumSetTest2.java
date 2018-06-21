package crazyBook.C8.C8_3;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;


/*
* 当试图复制一个Collection集合里的元素来创建EnumSet集合时,必须保证Collection
* 集合里的所有元素都是同一个枚举类的枚举值
* */
public class EnumSetTest2 {
    public static void main(String[] args) {
        Collection c = new HashSet();
        c.clear();
        c.add(Season.FALL);
        c.add(Season.SPRING);
        // 复制Collection集合中的所有元素来创建EnumSet集合
        EnumSet enumSet = EnumSet.copyOf(c);
        System.out.println(enumSet);

        c.add("疯狂java讲义");
        c.add("轻量级Java EE企业应用实战 ");
        // 下面代码出现异常:因为c集合里的元素不是全部都为枚举值
        //enumSet = enumSet.copyOf(c);

    }
}
