package ELSE.Day12.HomeWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Grade {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 20070301; i <= 20070320; i++) {
            list.add(
                    new Student(i, random.nextInt(100) + 1)
            );
        }

        System.out.println("目前列表中的学生成绩及序列为");
        list.forEach(s -> System.out.println(s));
        System.out.println("共" + list.size() + "人 ");

        System.out.println("\n\n\n----------------------------------------");

        //使用Collections工具方法，并让Student类继承Comparable接口方法
        /*Collections.sort(list);*/


        //使用TreeSet
        //由于上一个方法已经为Student实现了Comparable接口，其实构造方法中
        //不需要写匿名内部类
        TreeSet<Student> treeSet = new TreeSet<>(
                (o1,o2) -> {
                    if (o1.getGrade() == o2.getGrade()) {
                        return -1;
                    }
                    return o1.getGrade() - o2.getGrade();
                }
        );
        treeSet.addAll(list);
        list.clear();
        list.addAll(treeSet);



        System.out.println("按照成绩从高到低排序后");
        list.forEach(s -> System.out.println(s));
        System.out.println("共" + list.size() + "人 ");
    }
}
