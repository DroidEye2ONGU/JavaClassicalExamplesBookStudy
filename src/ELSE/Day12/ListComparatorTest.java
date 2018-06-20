package ELSE.Day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

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

        //Collections.sort(list, new ListComparator());
        //
        //System.out.println(list);

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
