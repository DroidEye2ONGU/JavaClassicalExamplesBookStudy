package ELSE.JavaSE.Day12.HomeWork;

import java.util.Scanner;
import java.util.TreeSet;

/*
* 从键盘接收一个字符串, 程序对其中所有字符进行排序,
* 例如键盘输入: helloitcast程序打印:acehillostt
* */
public class StringComapre {
    public static void main(String[] args) {
        String a;
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一串字符");
        a = sc.nextLine();

        char[] chars = a.toCharArray();
        //Character已经实现了Comparable接口中的方法，无需创建匿名内部类
        //但是因为重复字符只能存储一个，所以要重写
        TreeSet<Character> charSets = new TreeSet<>(
                (o1,o2) ->
                {
                    int num = o1.compareTo(o2);
                    return num == 0 ? -1 : num;
                }
        );

        for (char t :
                chars) {
            //在添加的过程中会自动进行排序
            charSets.add(new Character(t));
        }

        charSets.forEach(s-> System.out.print(s));
    }
}
