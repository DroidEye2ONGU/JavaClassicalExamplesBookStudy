package crazyBook.C8.C8_2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorEach {
    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("轻量级JavaEE企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂Android讲义");

        //获取books集合对应的迭代器
        Iterator<String> it = books.iterator();
        //使用Lambda表达式(目标类型使Consumer)来遍历集合元素
        /*it.forEachRemaining(
                obj -> System.out.println("迭代集合元素:" + obj)
        );*/

        it.forEachRemaining(
                obj -> {
                    System.out.println(obj);
                    if (obj.equals("疯狂java讲义")) {
                        //it.remove();

                        /*当使用Iterator迭代访问Collection集合元素时,
                        Collection集合里的元素不能被改变,只有通过
                        Iterator的remove()方法删除上一次next()方法
                        返回的集合元素才可以*/
                        //下面代码将报错
                        //books.remove("疯狂java讲义");
                    }
                }
        );

        System.out.println(books);

    }
}
