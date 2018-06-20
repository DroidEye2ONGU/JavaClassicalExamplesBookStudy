package ELSE.Day12.HomeWork;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.WeakHashMap;

public class ListComparatorTest{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ccc");
        list.add("ccc");
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("ddd");
        list.add("ddd");
       ListIterator A;

        //Collections.sort(list, new ListComparator());
        //
        //System.out.println(list);

        /*使用treeSet排序 当treeSet排序中，匿名内部类对相同的元素不返回0，则
        * TreeSet可以添加重复元素（即不认为这两个元素是重复的）
        * */
        TreeSet<String> treeSet = new TreeSet<>(
                (s1,s2) -> {
                    if (s1.equals(s2)) return -1;
                    return s1.compareTo(s2);
                }
        );

        treeSet.addAll(list);
        list.clear();
        list.addAll(treeSet);
        System.out.println(list);
    }


}
