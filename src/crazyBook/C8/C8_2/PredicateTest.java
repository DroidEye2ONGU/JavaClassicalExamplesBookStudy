package crazyBook.C8.C8_2;

import java.util.Collection;
import java.util.HashSet;

/*
* Java 8 为 Collection集合新增了一个removeIf(Predicate filter)方法,
* 该方法将会批量删除符合filter条件的所有元素.
* 该方法需要一个Predicate(谓词)对象作为参数,Predicate也是函数式接口,
* 因此可以使用Lambda表达式作为参数
* */
public class PredicateTest {
    public static void main(String[] args) {
        Collection<String> words = new HashSet<>();

        words.add("a");
        words.add("b");
        words.add("c");
        words.add("d");
        words.add("e");
        words.add("f");


        //使用Lambda表达式(目标类型使Predicate集合)过滤集合
        words.removeIf(
                ele -> ele.charAt(0) >= 'c' && ele.charAt(0) <= 'f'
        );
        System.out.println(words);
    }
}
