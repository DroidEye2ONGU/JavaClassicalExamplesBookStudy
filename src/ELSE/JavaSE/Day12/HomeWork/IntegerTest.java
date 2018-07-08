package ELSE.JavaSE.Day12.HomeWork;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 程序启动后, 可以从键盘输入接收多个整数, 直到输入quit时结束输入.
 * 把所有输入的整数倒序排列打印.
 * */
public class IntegerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> intSet = new TreeSet<>(
                (o1, o2) -> {
                    int num = o1 - o2;
                    return num == 0 ? -1 : -num;
                }
        );

        while (true) {
            String t = sc.nextLine();
            if (t.equals("quit")) break;
            intSet.add(Integer.parseInt(t));
        }

        intSet.forEach(s -> System.out.print(s + "\t"));

    }
}
