package crazyBook.C8.C8_3;

import java.util.EnumSet;

enum Season{
    SPRING,SUMMER,FALL,WINTER
        }

public class EnumSetTest {
    public static void main(String[] args) {
        // 创建一个EnumSet集合,集合元素就是Season枚举类的全部枚举值
        EnumSet es1 = EnumSet.allOf(Season.class);
        System.out.println(es1);

        //创建一个EnumSet空集合,指定其集合元素时Season类的枚举值
        EnumSet es2 = EnumSet.noneOf(Season.class);
        System.out.println(es2);

        //手动添加两个元素
        es2.add(Season.WINTER);
        es2.add(Season.SPRING);
        System.out.println(es2);

        //以指定枚举值创建EnumSet集合
        EnumSet es3 = EnumSet.of(Season.SUMMER, Season.WINTER);
        System.out.println(es3);

        //range(E from, E to) 创建一个包含从from枚举值到to枚举值范围内所有枚举值的EnumSet集合
        EnumSet es4 = EnumSet.range(Season.SUMMER, Season.WINTER);
        System.out.println(es4);
        //新创建的EnumSet集合元素和es4集合元素有相同的类型
        //es5集合元素+es4集合元素 = Season枚举类的全部枚举值
        //complementOf(EnumSet s):创建一个其元素类型与指定EnumSet里元素类型相同的
        //EnumSet集合,新EnumSet集合包含原EnumSet集合所不包含的,此枚举类剩下的枚举值
        //即新EnumSet集合和原EnumSet集合的集合元素加起来就是该枚举类的所有枚举值
        EnumSet es5 = EnumSet.complementOf(es4);
        System.out.println(es5);
    }
}
