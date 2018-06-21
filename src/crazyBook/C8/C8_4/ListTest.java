package crazyBook.C8.C8_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            numList.add(random.nextInt(20) + 1);
        }

        for (int i = 0; i < numList.size(); i++) {
            System.out.print(numList.get(i) + "\t");
            if ((i+1) % 10 == 0) System.out.println();
        }

        System.out.println("\n排序后----------------------");

        numList.sort(
                (o1,o2) -> {
                    int num = o1 - o2;
                    return num == 0 ? -1 : num;
                }
        );

        for (int i = 0; i < numList.size(); i++) {
            System.out.print(numList.get(i) + "\t");
            if ((i+1) % 10 == 0) System.out.println();
        }
        System.out.println();
        System.out.println("↓元素15在list中的位置↓");
        System.out.println(numList.indexOf(15));
        System.out.println(numList.get(numList.indexOf(15)));

        System.out.println("\n替换后----------------------");
        numList.set(numList.indexOf(15), 10);
        for (int i = 0; i < numList.size(); i++) {
            System.out.print(numList.get(i) + "\t");
            if ((i+1) % 10 == 0) System.out.println();
        }

        System.out.println("\n全部替换后----------------------");
        numList.replaceAll(
                o1->{
                    if (o1 <= 10) return 5;
                    return 15;
                }
        );
        for (int i = 0; i < numList.size(); i++) {
            System.out.print(numList.get(i) + "\t");
            if ((i+1) % 10 == 0) System.out.println();
        }
    }
}
