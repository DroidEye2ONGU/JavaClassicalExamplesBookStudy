package crazyBook.C8.C8_4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/*
* 与Set只提供了一个iterator()方法不同,List还额外提供了一个listIterator()方法,该方法
* 返回一个ListIterator对象,ListIterator接口继承自Iterator接口,提供了专门操作List的
* 方法.
* ListIterator接口在Iterator接口基础上增加了如下方法
* boolean hasPrevious() 相对于hasNext()
* Object previous()     相对于next()
* void add(Object o)    在当前位置的下一个位置添加元素
*
* ListIterator相对于普通的Iterator,增加了向前迭代的功能(Iterator只能向后迭代),
* 而且ListIterator还可以通过add()方法向List集合中添加元素(Iterator只能删除元素).
*
* 使用ListIterator迭代List集合时,开始也需要采用正向迭代,即先使用next()方法进行
* 迭代,在迭代过程中可以使用add()方法向上一次迭代元素的后面添加一个新元素.
* */
public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {
                "java指南",
                "林中秋雨",
                "愣鬼先锋"
        };
        List<String> bookList = new ArrayList<>();

        for (int i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }

        ListIterator<String> listIterator = bookList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            listIterator.add("-----------分隔符-----------");
        }
        System.out.println("======下面开始反向迭代======");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        System.out.println("======下使用ListIterator删除符合条件的元素 ======");
        bookList.add("愣鬼先锋2");
        bookList.add("愣鬼先锋3");
        bookList.add("愣鬼先锋4");
        bookList.add("愣鬼先锋5");
        listIterator = bookList.listIterator();
        while (listIterator.hasNext()) {
            String t = listIterator.next();
            System.out.println(t);
            if (t.contains("愣鬼")) {
                listIterator.remove();
                continue;
            }
        }
        System.out.println("---删除包含愣鬼的元素后");
        bookList.forEach(s-> System.out.println(s));
    }
}
