package crazyBook.C8.C8_3;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> books = new LinkedHashSet<>();
        books.add("疯狂 Java 讲义");
        books.add("轻量级Java EE企业应用实战");
        System.out.println(books);

        //删除疯狂Java讲义
        books.remove("疯狂 Java 讲义");
        //重新添加疯狂Java讲义
        books.add("疯狂 Java 讲义");

        System.out.println(books);

        /* 输出如下
        *   [疯狂 Java 讲义, 轻量级Java EE企业应用实战]
        *   [轻量级Java EE企业应用实战, 疯狂 Java 讲义]
        *
        * */
    }
}
