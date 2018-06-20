package ELSE.Day12.HomeWork;

import java.util.Scanner;
import java.util.TreeSet;

public class Student2Test {
    public static void main(String[] args) {

        TreeSet<Student2> stuSet = new TreeSet<>(
                (o1,o2) ->
                {
                    int num = o1.getTotalGrade() - o2.getTotalGrade();
                    return num == 0 ? -1 : -num;
                }
        );

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + i + 1 + "个学生信息：");
            int chinese;
            int math;
            int eng;

            System.out.print("请输入语文成绩：");
            chinese = sc.nextInt();
            System.out.print("请输入数学成绩：");
            math = sc.nextInt();
            System.out.print("请输入英语成绩：");
            eng = sc.nextInt();

            int total = chinese + math + eng;

            stuSet.add(new Student2("" + i, chinese, math, eng, total));
        }

        sc.close();

        System.out.println("按总分从高到低排序后为");

        stuSet.forEach(s -> System.out.println(s));
    }
}
