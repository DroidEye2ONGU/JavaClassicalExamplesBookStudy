package crazyBook.C8.C8_2;

import java.util.ArrayList;
import java.util.Collection;


public class ForeachTest {
    public static void main(String[] args) {
        Collection<String> books = new ArrayList<>();
        books.add("轻量级JavaEE企业应用实战");
        books.add("轻量级JavaEE企业应用实战");
        books.add("轻量级JavaEE企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂java讲义");
        books.add("疯狂java讲义");
        books.add("疯狂Android讲义");
        books.add("疯狂Android讲义");
        books.add("疯狂Android讲义");
        books.add("疯狂Android讲义");


        for (String t :
                books) {
            //此处的book变量也不是集合本身
            String book = t;
            System.out.println(t);
            if (book.equals("疯狂Android讲义")) {
                //下面代码会引发ConcurrentModificationException异常
                /*
                * 测试过程中使用HashSet不会报错,改成ArrayList会报错
                * 由于底层实际原因可能不会报错,但不要这样使用
                * */
                //books.remove(book);
            }
        }
        System.out.println(books);
    }
}
