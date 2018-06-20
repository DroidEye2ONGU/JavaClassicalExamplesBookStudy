package crazyBook.C8.C8_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("轻量级JavaEE企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂Android讲义");

        Iterator<String> it = books.iterator();
        while (it.hasNext()) {
            /*
            * 关于Iterator.remove()方法以及Iterator.next()方法
            * 1.Iterator.next()方法每调用一次,就会将迭代器的指针向后移动一位,
            *   也就是说,在一次迭代中多次调用next()方法会扰乱Iterator的第迭代顺序
            * 2.Iterator.remove()方法会删除元素中,Iterator上一次调用next()方法
            *   获得的元素.由于在一次循环中,获得一次元素的值就会调用一次next()方法,
            *   此时可以通过变量保存当前迭代到的元素,然后进行判断,若需要删除,直接
            *   调用iterator.remove()方法.如果不保存变量,由(1)可知,多次调用next()
            *   方法会扰乱迭代顺序,因此使逻辑出错
            * */

            String book = it.next();
            System.out.println(book);
            if (book.equals("疯狂java讲义")) {
                it.remove();
                continue;
            }

            //book = "测试字符串";
        }
        System.out.println(books);
    }
}
