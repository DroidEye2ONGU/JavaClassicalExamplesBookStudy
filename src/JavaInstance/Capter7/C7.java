package JavaInstance.Capter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C7 {


    //Arrays.asList()方法
    //List集合可允许重复元素，有顺序
    public static void asList() {
        List<Integer> integers = Arrays.asList(12, 32, 44);
        for (Integer t :
                integers) {
            System.out.println(t);
        }
    }

    //Set集合
    //Set集合不允许元素重复 无顺序
    public static void setTest() {
        Set<String> set = new HashSet();
        set.add("aa");
        set.add("aa");
        set.add("bb");
        set.add("cc");

        Iterator<String> stringIterator = set.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

    //链表结构
    public static void linkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("abc");
        linkedList.add("bbb");
    }

    //将一个数据项单向映射为另一个
    //使用HashMap或旧式的Hashtable
    /*
    *
         HashTable已经被淘汰了，不要在代码中再使用它。
        以下描述来自于HashTable的类注释：

            If a thread-safe implementation is not needed,
             it is recommended to use HashMap in place of
             Hashtable. If a thread-safe highly-concurrent
             implementation is desired, then it is recommended
             to use java.util.concurrent.ConcurrentHashMap in place of Hashtable.

        简单来说就是，如果你不需要线程安全，那么使用HashMap，
        如果需要线程安全，那么使用ConcurrentHashMap。
        HashTable已经被淘汰了，不要在新的代码中再使用它。
*/
    public static void hashTest() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        Iterator<String> iterator = map.keySet().iterator();
        Iterator<String> keyIterator = map.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }
    }

    //由集合转换为数组
    //使用集合类的toArray()方法
    /*
     * toArray()方法包含两个重载方法
     * 1.不带参数的toArray()方法，会返回改集合元素的数组
     * 2.带一个参数的toArray()方法，参数为要将集合放入的数组
     *   如果作为参数的数组足够大，那么这个数组将被填满返回。
     *   如果作为参数的数组不够大，那么会产生一个新的数组代替它
     * */
    public static void listToArray() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        Object[] ol = list.toArray();
        System.out.println("Array of String has length " + ol.length);

        System.out.println("--------------------------------------------------");
        String[] sl = list.toArray(new String[0]);
        System.out.println("Array of String has length " + sl.length);

        System.out.println("--------------------------------------------------");
        String[] sl2 = new String[list.size()];
        String[] strings = list.toArray(sl2);
        for (String t :
                sl2) {
            System.out.print(t + "\t");
        }
        System.out.println();
        System.out.println(sl2 == strings);

        System.out.println("--------------------------------------------------");
        String[] sl3 = new String[3];
        list.toArray(sl3);
        String[] strings1 = list.toArray(sl3);
        System.out.println(sl3 == strings1);
    }

    //迭代输出
    public static void iteratePrint() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        //List<String> strings = Arrays.asList("a", "b", "c");

        //Java8 Iterable.forEach方法
        /*
        * 1.声明一个集合
        * 2.使用Arrays.asList填充，给asList()方法传递一个文本数组
        * 3.调用集合的forEach()方法，传递一个lambda表达式
        * */
        System.out.println("Java8 Iterable.forEach方法");
        list.forEach(s -> System.out.print(s + "\t"));
        System.out.println();
        System.out.println("-----------------------------------------------------------------");

        //Java5的foreach循环
        System.out.println("Java5的foreach循环");
        for (String t :
                list) {
            System.out.print(t + "\t");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");


        //Java2的Iterator循环
        System.out.println("Java2的Iterator循环");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");

        //for循环与while循环 不举例
        System.out.println("for循环与while循环 不举例");
        //
    }

    //对集合进行排序
    //使用静态方法Arrays.sort()或Collections.sort(),还可以选择一个Comparator比较器
    /*
    * Comparator 和 Comparable 的区别
    * Comparable

     Comparable 定义在 Person类的内部:

        public class Persion implements Comparable {..比较Person的大小..},

         因为已经实现了比较器,那么我们的Person现在是一个可以比较大小的对象了,它的比较功能和String完全一样,可以随时随地的拿来比较大小,因为Person现在自身就是有大小之分的。Collections.sort(personList)可以得到正确的结果。

     Comparator

        Comparator 是定义在Person的外部的, 此时我们的Person类的结构不需要有任何变化,如

        public class Person{ String name; int age },

        然后我们另外定义一个比较器:

        public PersonComparator implements Comparator() {..比较Person的大小..},

        在PersonComparator里面实现了怎么比较两个Person的大小. 所以,用这种方法,当我们要对一个 personList进行排序的时候, 我们除了了要传递personList过去, 还需要把PersonComparator传递过去,因为怎么比较Person的大小是在PersonComparator里面实现的, 如:

        Collections.sort( personList , new PersonComparator() ).
        https://zhidao.baidu.com/question/440206984.html
    * */
    public static void arraysOrCollectionsSort() {
        //Arrays.sort()排序
        System.out.println("Arrays.sort()排序");
        String[] strings = {
                "painful",
                "mainly",
                "gaining",
                "raindrops"
        };
        Arrays.sort(strings);
        for (String t :
                strings) {
            System.out.print(t + " \t");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
    }
    public static void main(String[] args) {
        iteratePrint();

    }
}                         
