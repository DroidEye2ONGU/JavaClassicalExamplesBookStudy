package crazyBook.C8.C8_2;

import java.util.Collection;
import java.util.HashSet;

public class CollectionStream {
    public static void main(String[] args) {
        // 创建books集合、为books集合添加元素的代码与前一个程序相同。
        Collection<String> books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂iOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");

        //统计书名包含"疯狂"子串的图书数量
        System.out.println(
                books.stream().filter(
                        ela-> ela.contains("疯狂")
                ).count()
        );

        //统计书名包含"java"子串的图书数量
        System.out.println(
                books.stream().filter(
                        ela -> ela.contains("Java")
                ).count()
        );

        //统计书名字符串长度大于10的图书数量
        System.out.println(
                books.stream().filter(
                        ela -> ela.length() > 10
                ).count()
        );

        //先调用Collection对象的 Stream() 方法将集合转换为Stream
        //再调用Stream的mapToInt()方法获取原有的Stream对应的IntStream
        books.stream().mapToInt(
                ela-> ela.length())
                .forEach(System.out::println);
    }
}
