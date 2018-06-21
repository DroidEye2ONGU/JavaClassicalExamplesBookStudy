package crazyBook.C8.C8_2;

import java.util.stream.IntStream;

/*
* 独立使用Strean的步骤如下：
* ①使用Stream或XxxStream的builder()类方法创建该Stream对应的Builder
* ②重复调用Builder的add()方法向该流中添加多个元素
* ③调用Builder的build()方法获取对应的Stream
* ④调用Stream的聚集方法
* */

public class IntStreamTest {
    public static void main(String[] args) {
        IntStream is = IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();

        // 下面调用聚集方法的代码每次只能执行一行
        // 也就是这些流每次只能消费一次

        //末端方法,当对某个Stream执行末端方法后,该流将会被"消耗"且不可再用
        //中间方法:返回值是一个流


        System.out.println("is 所有元素的最大值:" + is.max().getAsInt());
        System.out.println("is 所有元素的最小值:" + is.min().getAsInt());
        System.out.println("is 所有元素的总和:" + is.sum());
        System.out.println("is 所有元素的总数:" + is.count());
        System.out.println("is 所有元素的平均值:" + is.average());
        System.out.println("is 所有元素的平方是否都大于20:" +
                is.allMatch(ele -> ele * ele > 20));
        System.out.println("is 是否包含任何元素的平方大于20:" +
                is.anyMatch(ela -> ela * ela > 20));

        //将 is 映射成一个新的Stream,新 Stream 的每个元素是原 Stream 元素的2倍+1
        IntStream newIs = is.map(ela -> 2 * ela + 1);
        //使用方法引用的方式来遍历集合元素
        newIs.forEach(System.out::println);
    }
}
